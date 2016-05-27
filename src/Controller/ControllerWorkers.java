package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Courses;
import Model.Days;
import Model.ErrorException;
import Model.Person;
import Model.Professor;
import Model.WarningException;

public class ControllerWorkers implements ControllerWorkersInterface {

    private SaveControllerInterface controller = new SaveController();
    private List<Reservation> listReservation = controller.getObjToSave().getListReservation();

    public void addRes(Reservation cont) throws WarningException, ErrorException {

        this.listReservation.add(cont);

    }
    
    public boolean removeRes(Reservation cont) throws WarningException {
        
        if( this.listReservation.contains(cont)){
           this.listReservation.remove(cont);
           controller.getObjToSave().setListReservation(this.listReservation);
           return true;
        }
            
        throw new WarningException("Non è stata trovata nessuna corrispondenza");
        
    }

    public List<Reservation> getListReservation()throws ErrorException{
        if(this.listReservation.isEmpty()){
            throw new ErrorException("Nessun dato da cancellare. \n Inserire dei dati prima di cancellarli. IDIOTA ");
        }
        return this.listReservation;
    }

    public Reservation undo() {

        return null;

    }

    public List<Reservation> getByDay(Days d) {
        List<Reservation> listByDay = new ArrayList<>();
        for (Reservation res : listReservation) {
            if (res.getDay().getString().equals(d.getString())) {
                listByDay.add(res);
            }
        }
        return listByDay;
    }

   /* public List<Reservation> getByClass(Room c) {
        List<Reservation> listByRoom = new ArrayList<>();

        for (Reservation res : listReservation) {
            if (res.getRoom().equals(c)) {
                listByRoom.add(res);
            }
        }
        return listByRoom;
    }*/

    public List<Reservation> getByCourses(Courses course) {
        List<Reservation> listByCourses = new ArrayList<>();
        for (Reservation res : listReservation) {
            if (res.getCourse().getName().equals(course.getName())) {
                listByCourses.add(res);
            }
        }
        return listByCourses;
    }

    public List<Reservation> getByProfessor(Person p) {
        List<Reservation> listByProf = new ArrayList<>();

        for (Reservation res : listReservation) {
            if (res.getPerson().toString().equals(p.toString())) {
                listByProf.add(res);
                System.out.print(res.getPerson().toString());
            }
        }
        return listByProf;
    }

  /*  public List<Reservation> getByHour(Hours h) {
        List<Reservation> listByHours = new ArrayList<>();

        for (Reservation res : listReservation) {
            if (res.getHour().equals(h)) {
                listByHours.add(res);
            }
        }
        return listByHours;
    }*/

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
