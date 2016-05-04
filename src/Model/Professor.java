package Model;

import java.util.Set;

public interface Professor {

    public Person getProf();
    
    public void setProf(Person prof);
    
    public Set<ListCourses> getCourses();

    public void setCourses(Set<ListCourses> courses);

    public void addCourse(ListCourses c);
}