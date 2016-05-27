package Controller;

import java.io.Serializable;

import Model.CoursesImpl;
import Model.Days;
import Model.Hours;
import Model.PersonImpl;
import Model.RoomImpl;

public class Reservation implements ReservationInterface, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Hours hour = null;
    private Days day = null;
    private CoursesImpl course = null;
    private RoomImpl room = null;
    private PersonImpl prof = null;

    public Reservation(PersonImpl p, CoursesImpl c, Days d, Hours hour, RoomImpl room) {
        this.prof = p;
        this.course = c;
        this.hour = hour;
        this.day = d;
        this.room = room;
    }

    public void setPerson(PersonImpl prof) {
        this.prof = prof;
    }

    public void setCourse(CoursesImpl course) {
        this.course = course;

    }

    public void setHour(Hours hour) {
        this.hour = hour;

    }

    public void setRoom(RoomImpl room) {
        this.room = room;
    }

    public PersonImpl getPerson() {
        return this.prof;
    }

    public CoursesImpl getCourse() {
        return this.course;
    }

    public Hours getHour() {
        return this.hour;
    }

    public RoomImpl getRoom() {
        return this.room;
    }

    public String toString() {
        return this.getDay()+" Ora: " + this.hour.getValue() + " Stanza: " +this.room.getNameRoom()+
                "\n prof: " + this.prof.getName() +" " + this.prof.getSurname() + " Corso: " + this.course.getName()  ;
    }

    public Days getDay() {
        return day;
    }

    public void setDay(Days day) {
        this.day = day;
    }

    public boolean isset() {
       if(chechNull(this.day)||chechNull(this.course)||chechNull(this.hour)
                   ||chechNull(this.room)||chechNull(this.prof)){
           return false;
       }
        return true;
    }
    
    private Boolean chechNull(Object a){
        if(a.equals(null)||a.equals(" ")){
            return false;
        }
        
        return true;
        
    }

}
