package Controller;

import java.util.Set;

import Model.ListRoom;
import Model.Days;
import Model.ListCourses;
import Model.ListProfessor;

public class ControllerWorkers implements ControllerWorkersInterface {

    private Set<Controller> allList;
    private Set<Controller> byProfessor;
    private Set<Controller> byDay;
    private Set<Controller> byClas;
    private Set<Controller> byCourse;

    public void add(Controller cont) {

        if (!this.allList.contains(cont) && check(cont)) {
            this.allList.add(cont);
        } else {
            throw new IllegalArgumentException();
        }

    }

    private boolean check(Controller cont) {
        boolean check = true;
        for (Controller controller : allList) {
            if (cont.getDay().equals(controller.getDay()) && cont.getHours().equals(controller.getHours())) {
                check = false;
            }
        }
        return check;

    }


    public Set<Controller> getAll() {
        return this.allList;
    }

  
    public Set<Controller> getByDay(Days d) {
        if(this.allList.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            for (Controller controller : allList) {
                if (controller.getClas().getValue().equals(d.getValue())) {
                    this.byDay.add(controller);
                }
            }
        }
        
        if(this.byClas.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            return this.byDay;
        }
    }

    public Set<Controller> getByClass(ListRoom c) {
        
        if(this.allList.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            for (Controller controller : allList) {
                if (controller.getClas().getValue().equals(c.getValue())) {
                    this.byClas.add(controller);
                }
            }
        }
        
        if(this.byClas.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            return this.byClas;
        }
       
    }

    public Set<Controller> getByCourses(ListCourses course) {
        
        if(this.allList.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            for (Controller controller : allList) {
                if (controller.getClas().getValue().equals(course.getValue())) {
                    this.byCourse.add(controller);
                }
            }
        }
        
        if(this.byClas.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            return this.byCourse;
        }
    }

    public Set<Controller> getByProfessor(ListProfessor p) {
        if(this.allList.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            for (ListCourses c : ListCourses.values()) {
                
            }
            for (Controller controller : allList) {
                if (controller.getCourse().getValue().equals(p.getName())) {
                    this.byProfessor.add(controller);
                }
            }
        }
        
        if(this.byClas.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            return this.byProfessor;
        }
    }

}
