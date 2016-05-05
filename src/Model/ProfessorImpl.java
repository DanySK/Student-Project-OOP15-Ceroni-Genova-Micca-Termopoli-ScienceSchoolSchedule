package Model;

import java.util.HashSet;
import java.util.Set;

public class ProfessorImpl extends PersonImpl implements Professor {

  
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Person prof;
    private static String name;
    private static String surname;
    private Set<ListCourses> courses = new HashSet<>();

    public ProfessorImpl(Person prof, Set<ListCourses> courses) {
        super(name , surname);
        this.prof = prof;
        this.courses = courses;

    }

    public Person getPerson() {
        return prof;
    }

    public void setPerson(Person prof) {
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
