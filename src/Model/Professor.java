package Model;

import java.util.Set;

public interface Professor{

    public Person getPerson();
    
    public void setPerson(Person prof);
    
    public Set<ListCourses> getCourses();

    public void setCourses(Set<ListCourses> courses);

    public void addCourse(ListCourses c);
    public String toString();
}