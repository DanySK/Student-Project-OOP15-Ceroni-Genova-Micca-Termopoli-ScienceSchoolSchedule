package Controller;

import java.util.Set;

import Model.ListRoom;
import Model.Days;
import Model.ListCourses;
import Model.ListProfessor;

public interface ControllerWorkersInterface {

    public void add(Controller cont) ;
    
    public Set<Controller> getAll();
    
    public Set<Controller> getByDay( Days d);
    
    public Set<Controller> getByClass( ListRoom c);
    
    public Set<Controller> getByCourses( ListCourses course);
    
    public Set<Controller> getByProfessor( ListProfessor p);
}
