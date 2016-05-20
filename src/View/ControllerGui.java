package View;

import java.awt.Color;
import java.awt.Component;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.Reservation;
import Controller.SaveController;
import Controller.SaveControllerInterface;
import Model.CoursesImpl;
import Model.Days;
import Model.Hours;
import Model.PersonImpl;
import Model.Professor;
import Model.Room;
import Model.RoomImpl;

public class ControllerGui {

    private final SaveControllerInterface cont = new SaveController();
    private Set<Reservation> setReservation = cont.getObjToSave().getListReservation();
    private DefaultTableModel table = new TableGUI();
    private JTable jtable = new JTable(table);

    private void drawTable() {
        drawDefaultTable();

        for (Reservation res : this.setReservation) {

            this.table.setValueAt(res.getCourse().getName(), this.getRow(res), this.getColum(res));

        }

    }

    private class MyRenderer extends DefaultTableCellRenderer {

        private static final long serialVersionUID = -2738263676362042563L;
        private Set<Reservation> setReservation = cont.getObjToSave().getListReservation();

        public Component getTableCellRendererComponent(final JTable tab, final Object value, final boolean selected,
                final boolean focused, final int row, final int column) {
            super.getTableCellRendererComponent(tab, value, false, focused, row, column);
            this.setHorizontalAlignment(CENTER);
            this.setHorizontalAlignment(CENTER);
           /* if (value instanceof String[]) {
                setListData((String[]) value);
            }*/
            if (row == 0 || column == 0 || (0 == (row % (cont.getObjToSave().getListRoom().size() + 1)))) {
                this.setBackground(Color.GRAY);
            } else if ((String) value == "") {
                this.setBackground(Color.WHITE);
            } else {
                Color c = Color.white;
                for (Reservation res : this.setReservation) {

                    if ((String) value == res.getCourse().getName())
                        c = res.getCourse().getType().getColor();
                }
                this.setBackground(c);
            }

            return this;
        }
    }

    private void drawDefaultTable() {
        int i = 0;
        for (Days days : Days.values()) {
            int y = 1;
            for (Hours hours : Hours.values()) {

                this.jtable.setValueAt(hours.getValue(), i, y);
                y++;
            }
            this.jtable.setValueAt(days.getString(), i++, 0);

            for (Room room : this.cont.getObjToSave().getListRoom()) {
                this.jtable.setValueAt(room.getNameRoom(), i++, 0);
            }
        }
    }

    public JTable getTable() {

        drawDefaultTable();
        drawTable();
        this.jtable.setDefaultRenderer(this.jtable.getColumnClass(0), new MyRenderer());

        return this.jtable;

    }

    public Integer getRow(Reservation res) {
        int row = 0;
        drawDefaultTable();
        for (int r = 0; r < jtable.getRowCount(); r++) {
            if (this.jtable.getValueAt(r, 0).equals(res.getDay().getString())) {
                for (int a = r; a <= r + cont.getObjToSave().getListRoom().size(); a++) {
                    if ((this.jtable.getValueAt(a, 0).toString()).equals(res.getRoom().getNameRoom())) {
                        row = a;
                    }

                }
            }

        }
        return row;
    }

    public Integer getColum(Reservation res) {
        int colum = 0;
        drawDefaultTable();
        for (int c = 0; c < jtable.getColumnCount(); c++) {
            if (this.jtable.getValueAt(0, c).toString().equals(res.getHour().getValue())) {
                colum = c;
            }
        }
        return colum;
    }

    public Reservation matchString(String prof, String corso, String giorno, String ora, String stanza) {
        PersonImpl person = null;
        CoursesImpl cours = null;
        for (Professor p : cont.getObjToSave().getListProfessor()) {

            if (p.getPerson().toString().equals(prof)) {
                person = new PersonImpl(p.getPerson().getName(), p.getPerson().getSurname());

                for (CoursesImpl cous : p.getCourses()) {
                    if (cous.getName().equals(corso)) {
                        cours = new CoursesImpl(cous.getName(), cous.getType());
                    }

                }
            }

        }
        Days day = null;
        for (Days d : Days.values()) {
            if (d.getString().equals(giorno)) {
                day = d;
            }
        }
        Hours h = null;
        for (Hours ho : Hours.values()) {
            if (ho.getValue().equals(ora)) {
                h = ho;
            }
        }
        RoomImpl room = null;
        for (RoomImpl r : cont.getObjToSave().getListRoom()) {
            if (r.getNameRoom().equals(stanza)) {
                room = r;
            }
        }

        return new Reservation(person, cours, day, h, room);
    }

}
