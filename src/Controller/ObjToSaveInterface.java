package Controller;

import java.util.Set;

import Model.Hours;
import Model.ListCourses;
import Model.ListRoom;
import Model.Professor;

public interface ObjToSaveInterface {

    public void setProf(Professor prof);

    public void setCourse(Set<ListCourses > course);

    public void setHour(Hours hour);

    public void setRoom(ListRoom room);

    public Professor getProf();

    public Set<ListCourses> getCourses();

    public Hours getHour();

    public ListRoom getRoom();

}