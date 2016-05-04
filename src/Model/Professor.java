package Model;

import java.util.HashSet;
import java.util.Set;

public class Professor implements ProfessorInterface {

    private Person prof;
    private Set<ListCourses> courses = new HashSet<>();

    public Professor(Person prof, Set<ListCourses> courses) {
        this.prof = prof;
        this.courses = courses;

    }

    public Person getProf() {
        return prof;
    }

    public void setProf(Person prof) {
        this.prof = prof;
    }

    public Set<ListCourses> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<ListCourses> courses) {
        this.courses = courses;
    }

    public void addCourse(ListCourses c) {
        this.courses.add(c);
    }

}
