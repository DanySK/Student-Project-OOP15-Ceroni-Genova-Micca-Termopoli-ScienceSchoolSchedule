package Controller;

import java.util.Set;

import Model.Courses;
import Model.Days;
import Model.Person;
import Model.Room;

public interface ControllerWorkersInterface {

    public void addRes(Reservation cont);

    public Set<Reservation> getListReservation();
  /*  private boolean validate(Reservation cont) ;

    private boolean checkPeriod(Reservation cont);

    private boolean check4TimeWeekProfessor(Reservation cont);

    private boolean check4TimeWeekStudent(Reservation cont);

    private Boolean checkCDLSecondYear(Reservation cont);
    private Boolean checkCDLThirdYear(Reservation cont);
*/
    public Set<Reservation> getByDay(Days d);

    public Set<Reservation> getByClass(Room c);

    public Set<Reservation> getByCourses(Courses course);

    public Set<Reservation> getByProfessor(Person p);

}