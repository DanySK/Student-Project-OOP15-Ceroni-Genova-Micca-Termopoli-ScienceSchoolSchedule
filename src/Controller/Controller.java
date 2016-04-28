package Controller;

import Model.Days;
import Model.Hours;
import Model.ListCourses;
import Model.ListRoom;

public class Controller implements ControllerInterface {
    
  

    private Hours hours;
    private ListCourses course;
    private Days day;
    private ListRoom clas;
    
    public Controller(Hours hours, ListCourses course, Days day, ListRoom clas) {
        super();
        this.hours = hours;
        this.course = course;
        this.day = day;
        this.clas = clas;
    }
    
    /* (non-Javadoc)
     * @see Controller.ControllerInterface#getHours()
     */
    public Hours getHours() {
        return hours;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#setHours(Model.Hours)
     */
    public void setHours(Hours hours) {
        this.hours = hours;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#getCourse()
     */
    public ListCourses getCourse() {
        return course;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#setCourse(Model.ListCourses)
     */
    public void setCourse(ListCourses course) {
        this.course = course;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#getDay()
     */
    public Days getDay() {
        return day;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#setDay(Model.Days)
     */
    public void setDay(Days day) {
        this.day = day;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#getClas()
     */
    public ListRoom getClas() {
        return clas;
    }

    /* (non-Javadoc)
     * @see Controller.ControllerInterface#setClas(Model.Class)
     */
    public void setClas(ListRoom clas) {
        this.clas = clas;
    }
    




  
    
    
    
  
    
}
