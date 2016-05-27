package Controller;

import java.util.List;

import Model.Courses;
import Model.Days;
import Model.ErrorException;
import Model.Hours;
import Model.Person;
import Model.Professor;
import Model.Room;
import Model.WarningException;

public interface ControllerWorkersInterface {

    public void addRes(Reservation cont) throws WarningException, ErrorException;

    public List<Reservation> getListReservation();

    public List<Reservation> getByDay(Days d);

    public List<Reservation> getByClass(Room c);

    public List<Reservation> getByProfessor(Person p);

    public List<Reservation> getByHour(Hours h);

    public List<Courses> getCoursesFromFile();

    public List<Professor> getProfessorFromFile();
}