package Controller;

import java.util.List;

import Model.Courses;
import Model.Days;
import Model.ErrorException;
import Model.Professor;
import Model.WarningException;

public interface ControllerWorkersInterface {

    public void addRes(Reservation cont) throws WarningException, ErrorException;

    public List<Reservation> getListReservation() throws  ErrorException;

    public List<Reservation> getByDay(Days d);

    public List<Reservation> getByCourses(Courses course);
    // public List<Reservation> getByClass(Room c);

    // public List<Reservation> getByProfessor(Person p);

    // public List<Reservation> getByHour(Hours h);

    public List<Courses> getCoursesFromFile();

    public List<Professor> getProfessorFromFile();

    public void removeRes(Reservation cont) throws WarningException;
}