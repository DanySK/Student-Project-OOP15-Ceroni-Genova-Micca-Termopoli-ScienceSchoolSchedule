package View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<Reservation> listReservation = cont.getObjToSave().getListReservation();
    private DefaultTableModel table = new TableGUI();

    private void drawTable() {
        drawDefaultTable();
        for (Reservation res : this.listReservation) {
            this.table.setValueAt(res.getCourse().getName() + " \n" + res.getPerson().getSurname(), this.getRow(res),
                    this.getColum(res));
            this.table.fireTableCellUpdated(this.getRow(res), this.getColum(res));
            // this.table.newDataAvailable(event);
        }
        this.table.fireTableDataChanged();
    }

    private void drawDefaultTable() {
        int i = 0;
        for (Days days : Days.values()) {
            int y = 1;
            for (Hours hours : Hours.values()) {

                this.table.setValueAt(hours.getValue().toUpperCase(), i, y++);

            }
            this.table.setValueAt(days.getString(), i++, 0);
            for (Room room : this.cont.getObjToSave().getListRoom()) {
                this.table.setValueAt(room.getNameRoom(), i++, 0);
            }
        }
    }

    public DefaultTableModel getTable() {
        if (this.listReservation.isEmpty()) {
            drawDefaultTable();
        } else {

            drawTable();
        }

        return this.table;

    }

    public Integer getRow(Reservation res) {
        int row = 0;
        drawDefaultTable();
        for (int r = 0; r < table.getRowCount(); r++) {
            if (this.table.getValueAt(r, 0).equals(res.getDay().getString())) {
                for (int a = r; a <= r + cont.getObjToSave().getListRoom().size(); a++) {
                    if ((this.table.getValueAt(a, 0).toString()).equals(res.getRoom().getNameRoom())) {
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
        for (int c = 0; c < table.getColumnCount(); c++) {
            if (this.table.getValueAt(0, c).toString().equals(res.getHour().getValue())) {
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

    public SaveControllerInterface getCont() {
        return this.cont;
    }
    
    public ControllerGui getControllerGui() {
        return this;
    }

}
