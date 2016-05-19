package Controller;

import Model.CoursesImpl;
import Model.Hours;
import Model.PersonImpl;
import Model.RoomImpl;

public interface ReservationInterface {

    public void setPerson(PersonImpl prof);

    public void setCourse(CoursesImpl course);

    public void setHour(Hours hour);

    public void setRoom(RoomImpl room);

    public PersonImpl getPerson();

    public CoursesImpl getCourse();

    public Hours getHour();

    public RoomImpl getRoom();

}