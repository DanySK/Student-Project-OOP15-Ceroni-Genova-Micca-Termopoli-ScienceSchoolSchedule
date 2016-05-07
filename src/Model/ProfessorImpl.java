package Model;

import java.util.ArrayList;
import java.util.List;

public class ProfessorImpl extends PersonImpl implements Professor {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Person prof;
    private static String name;
    private static String surname;
    private List<Courses> courses = new ArrayList<>();

    public ProfessorImpl(Person prof, List<Courses> courses) {
        super(name, surname);
        this.prof = prof;
        this.courses = courses;
    }

    public Person getPerson() {
        return prof;
    }

    public void setPerson(Person prof) {
        this.prof = prof;
    }

    public List<Courses> getCourses() {
        return this.courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public void addCourse(Courses c) {
        this.courses.add(c);
    }

    private List<String> toStringCorsi() {
        List<String> tmp = new ArrayList<>();
        for (Courses courses2 : courses) {
            tmp.add(courses2.getName());
        }
        return tmp;

    }

    public String toString() {

        return "name : " + this.prof.getName() + " cognome: " + this.prof.getSurname() + " Lista cosi: "
                + this.toStringCorsi();

    }
}
