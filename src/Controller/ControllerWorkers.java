package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import Model.Courses;
import Model.Days;
import Model.Hours;
import Model.Person;
import Model.Professor;
import Model.Room;

public class ControllerWorkers implements ControllerWorkersInterface {

    private SaveControllerInterface controller = new SaveController();
    private Set<Reservation> listReservation = controller.getObjToSave().getListReservation();

    public void addRes(Reservation cont) {

        if (check(cont)) {
            this.listReservation.add(cont);
        } else {
            JOptionPane.showMessageDialog(null, "Non disponibile!", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    private boolean validate(Reservation cont) {

        if (!check(cont)) {
            throw new IllegalArgumentException();// posto gia occupato
        } else if (!checkPeriod(cont)) {
            throw new IllegalArgumentException(); // 6 ore al giorno
            /* }else if(){ */

        }

        return false;
    }

    private boolean checkPeriod(Reservation cont) {
        int i = 0;

        for (Reservation reservation : this.getByDay(cont.getDay())) {
            if (reservation.equals(cont)) {
                i++;
            }
        }
        return i <= 6 ? true : false;
    }

    private boolean check4TimeWeekProfessor(Reservation cont) {
        int i = 0;
        Set<Integer> tempCount = new HashSet<>();
        for (Reservation reservation : this.getByProfessor(cont.getPerson())) {
            for (Days d : Days.values()) {
                i = 0;
                if (reservation.getDay().equals(d)) {
                    i++;
                }
                if (i != 0) {
                    tempCount.add(i);
                }

            }
        }
        return tempCount.size() <= 4 ? true : false;
    }

    private boolean check4TimeWeekStudent(Reservation cont) {

        return false;
    }

    private Boolean checkCDLSecondYear(Reservation cont) {
        boolean check = false;

        for (Reservation res : this.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())
                    && !cont.getRoom().getNameRoom().equals(res.getRoom().getNameRoom())) {

                if (cont.getCourse().getType().equals(Model.Type.SECOND_YEAR_ENG)
                        && res.getCourse().getType().equals(Model.Type.SECOND_YEAR_SCI)) {
                    check = true;
                }
            }
        }
        return check;
    }

    private Boolean checkCDLThirdYear(Reservation cont) {
        boolean check = false;

        for (Reservation res : this.getByDay(cont.getDay())) {
            if ((cont.getHour().getValue()).equals(res.getHour().getValue())
                    && !cont.getRoom().getNameRoom().equals(res.getRoom().getNameRoom())) {

                if (cont.getCourse().getType().equals(Model.Type.SECOND_YEAR_ENG)
                        && res.getCourse().getType().equals(Model.Type.SECOND_YEAR_SCI)) {
                    check = true;
                }
            }
        }
        return check;
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
