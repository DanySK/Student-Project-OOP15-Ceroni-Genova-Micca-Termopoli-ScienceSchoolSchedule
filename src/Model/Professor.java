package Model;

import java.util.List;

public interface Professor{

    public Person getPerson();
    
    public void setPerson(Person prof);
    
    public List<Courses> getCourses();

    public void setCourses(List<Courses> courses);

    public void addCourse(Courses c);
    public String toString();
}