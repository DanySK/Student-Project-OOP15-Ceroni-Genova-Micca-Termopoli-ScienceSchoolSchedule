package Controller;

import java.util.Set;

import Model.Courses;
import Model.Days;
import Model.Person;
import Model.Room;

public interface ControllerWorkersInterface {

    public void addRes(Reservation cont);

    public Set<Reservation> getListReservation();

    public Set<Reservation> getByDay(Days d);

    public Set<Reservation> getByClass(Room c);

    public Set<Reservation> getByCourses(Courses course);

    public Set<Reservation> getByProfessor(Person p);

}