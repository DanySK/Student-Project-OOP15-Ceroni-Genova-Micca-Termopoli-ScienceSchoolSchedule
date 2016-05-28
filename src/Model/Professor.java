package Model;

import java.util.List;

public interface Professor{

    public Person getPerson();
    
    public void setPerson(Person prof);
    
    public List<CoursesImpl> getCourses();

    public void setCourses(List<CoursesImpl> courses);

    public void addCourse(CoursesImpl c);
    
    public String toString();
}