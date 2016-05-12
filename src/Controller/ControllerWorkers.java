package Controller;

import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import Model.Courses;
import Model.Days;
import Model.Hours;
import Model.Person;
import Model.Room;

public class ControllerWorkers implements ControllerWorkersInterface {

    private SaveControllerInterface controller = new SaveController();
    private Set<Reservation> listReservation = controller.getObjToSave().getListReservation();

    public void add(Reservation cont) {

        if (!this.listReservation.contains(cont) && check(cont)) {
            this.listReservation.add(cont);
        } else {
            JOptionPane.showMessageDialog(null, "Non disponibile!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean check(Reservation cont) {
        boolean check = true;
       // if (cont.isset()) {
            for (Reservation res : listReservation) {
                if (cont.getDay().equals(res.getDay()) && cont.getHour().equals(res.getHour())
                        && cont.getRoom().equals(res.getRoom())) {
                    check = false;
                } else {
                   // JOptionPane.showMessageDialog(null, "errore gia presente!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
      //  } else { 
           // JOptionPane.showMessageDialog(null, "Impostare tutti i campi della form!", "Error", JOptionPane.ERROR_MESSAGE);
      //      check = false;
     //   }

        return check;

    }

    public Set<Reservation> getListReservation() {
        return this.listReservation;
    }

    public Set<Reservation> getByDay(Days d) {
        Set<Reservation> listByDay = new HashSet<>();
        if (this.listReservation.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Reservation res : listReservation) {
                if (res.getDay().equals(d.getValue())) {
                    listByDay.add(res);
                }
            }
        }

        if (listByDay.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return listByDay;
        }
    }

    public Set<Reservation> getByClass(Room c) {
        Set<Reservation> listByRoom = new HashSet<>();
        if (this.listReservation.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Reservation res : listReservation) {
                if (res.getRoom().equals(c)) {
                    listByRoom.add(res);
                }
            }
        }

        if (listByRoom.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return listByRoom;
        }

    }

    public Set<Reservation> getByCourses(Courses course) {
        Set<Reservation> listByCourses = new HashSet<>();
        if (this.listReservation.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Reservation res : listReservation) {
                if (res.getCourse().equals(course)) {
                    listByCourses.add(res);
                }
            }
        }

        if (listByCourses.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return listByCourses;
        }
    }

    public Set<Reservation> getByProfessor(Person p) {
        Set<Reservation> listByProf = new HashSet<>();
        if (this.listReservation.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Reservation res : listReservation) {
                if (res.getPerson().equals(p)) {
                    listByProf.add(res);
                }
            }
        }

        if (listByProf.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return listByProf;
        }
    }

    public Set<Reservation> getByHour(Hours h) {
        Set<Reservation> listByHours = new HashSet<>();
        if (this.listReservation.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Reservation res : listReservation) {
                if (res.getHour().equals(h)) {
                    listByHours.add(res);
                }
            }
        }

        if (listByHours.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return listByHours;
        }
    }

}
