package Controller;

import Model.Days;
import Model.Hours;
import Model.ListCourses;
import Model.ListRoom;

public interface ControllerInterface {

    public Hours getHours();

    public void setHours(Hours hours);

    public ListCourses getCourse();

    public void setCourse(ListCourses course);

    public Days getDay();

    public void setDay(Days day);

    public  ListRoom getClas();

    public void setClas(ListRoom clas);

}