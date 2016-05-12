package View;

import java.util.Set;

import javax.swing.table.TableModel;

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
    private TableModel table = new TableGUI();

    private void drawTable() {
        drawDefaultTable();
        for (Reservation res : this.setReservation) {
            for (int c = 0; c < table.getColumnCount(); c++) {
                if (this.table.getValueAt(0, c).toString().equals(res.getHour().getValue())) {
                    for (int r = 0; r < table.getRowCount(); r++) {
                        if (this.table.getValueAt(r, 0).equals(res.getDay().getString())) {
                            for (int a = r; a <= r + cont.getObjToSave().getListRoom().size(); a++) {
                                if ((this.table.getValueAt(a, 0).toString()).equals(res.getRoom().getNameRoom())) {
                                    this.table.setValueAt(res.getCourse().getName() + res.getPerson().getSurname(), a,
                                            c);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void drawDefaultTable() {
        int i = 0;
        for (Days days : Days.values()) {
            int y = 1;
            for (Hours hours : Hours.values()) {
                if (i == 0) {
                    this.table.setValueAt(hours.getValue(), 0, y++);
                } else {
                    this.table.setValueAt(hours.getValue(), i, y++);
                }
            }
            this.table.setValueAt(days.getString(), i++, 0);
            for (Room room : this.cont.getObjToSave().getListRoom()) {
                this.table.setValueAt(room.getNameRoom(), i++, 0);
            }
        }
    }

    public TableModel getTable() {
        if (this.setReservation.isEmpty()) {
            drawDefaultTable();
        } else {

            drawTable();
        }

        return this.table;

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
