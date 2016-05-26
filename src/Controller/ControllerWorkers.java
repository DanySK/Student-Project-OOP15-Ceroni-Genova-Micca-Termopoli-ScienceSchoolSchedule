package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Courses;
import Model.Days;
import Model.Hours;
import Model.Person;
import Model.Professor;
import Model.Room;
import Model.WarningException;

public class ControllerWorkers implements ControllerWorkersInterface {

    private SaveControllerInterface controller = new SaveController();
    private Set<Reservation> listReservation = controller.getObjToSave().getListReservation();

    public void addRes(Reservation cont) throws WarningException {

        if (check(cont)) {
            this.listReservation.add(cont);
        } else {
            throw new WarningException("Aula e orario non disponibile!");
        }
    }

    private boolean check(Reservation cont) {
        boolean check = true;
        for (Reservation res : listReservation) {
            if (((cont.getDay().getString()).equals(res.getDay().getString())
                    && ((cont.getHour().getValue()).equals(res.getHour().getValue())))
                    && ((cont.getRoom().getNameRoom()).equals(res.getRoom().getNameRoom()))) {
                check = false;
            } else {
                // JOptionPane.showMessageDialog(null, "errore gia presente!",
                // "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

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
                if (res.getDay().getString().equals(d.getString())) {
                    listByDay.add(res);
                }
            }
        }
        return listByDay;
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
                if (res.getCourse().getName().equals(course.getName())) {
                    listByCourses.add(res);
                }
            }
        }
        return listByCourses;
    }

    public Set<Reservation> getByProfessor(Person p) {
        Set<Reservation> listByProf = new HashSet<>();
        if (this.listReservation.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            for (Reservation res : listReservation) {
                if (res.getPerson().toString().equals(p.toString())) {
                    listByProf.add(res);
                    System.out.print(res.getPerson().toString());
                }
            }
        }
        return listByProf;
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

    public List<Courses> getCoursesFromFile() {
        List<Courses> temp = new ArrayList<>();
        for (Professor prof : controller.getObjToSave().getListProfessor()) {
            for (Courses courses : prof.getCourses()) {
                if (!temp.contains(courses)) {
                    temp.add(courses);
                }

            }

        }
        return temp;

    }

    public List<Professor> getProfessorFromFile() {
        List<Professor> temp = new ArrayList<>();
        for (Professor prof : controller.getObjToSave().getListProfessor()) {

            if (!temp.contains(prof)) {
                temp.add(prof);
            }

        }

        return temp;

    }

}
