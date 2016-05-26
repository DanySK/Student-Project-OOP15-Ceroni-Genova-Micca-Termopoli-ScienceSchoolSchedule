package Controller;

import java.util.List;
import java.util.Set;

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

    public Set<Reservation> getListReservation();

    public Set<Reservation> getByDay(Days d);

    public Set<Reservation> getByClass(Room c);

    public Set<Reservation> getByProfessor(Person p);

    public Set<Reservation> getByHour(Hours h);

    public List<Courses> getCoursesFromFile();

    public List<Professor> getProfessorFromFile();
}