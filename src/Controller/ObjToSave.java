package Controller;

import java.io.Serializable;
import java.util.Set;

import Model.Hours;
import Model.ListCourses;
import Model.ListRoom;
import Model.Professor;

public class ObjToSave implements ObjToSaveInterface, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Professor prof = null;
    private Hours hour = null;
    private ListRoom room = null;

    public ObjToSave(Professor prof, Hours hour, ListRoom room) {
        this.prof = prof;
        this.hour = hour;
        this.room = room;
    }

    public void setProf(Professor prof) {
        this.prof = prof;
    }

    public void setCourse(Set<ListCourses> course) {
        this.prof.setCourses(course);

    }

    public void setHour(Hours hour) {
        this.hour = hour;

    }

    public void setRoom(ListRoom room) {
        this.room = room;
    }

    public Professor getProf() {
        return this.prof;
    }

    public Set<ListCourses> getCourses() {
        return this.prof.getCourses();
    }

    public Hours getHour() {
        return this.hour;
    }

    public ListRoom getRoom() {
        return this.room;
    }

    public String toString() {
        return "prof: " + this.prof.getPerson().getName()+" "+this.prof.getPerson().getSurname() + " Corso :" + this.prof.getCourses()+ "Ora: " + this.hour + " Stanza: " + this.room;
    }

}
