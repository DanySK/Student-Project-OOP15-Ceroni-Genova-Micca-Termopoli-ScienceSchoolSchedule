package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Courses;
import Model.CoursesImpl;
import Model.ListCourses;
import Model.ListProfessor;
import Model.PersonImpl;
import Model.Professor;
import Model.ProfessorImpl;

public class ProfessorController implements ProfessorControllerInterface {
    private final String path = System.getProperty("user.home") + System.getProperty("file.separator")
            + "SiencesSchoolSchedul.dat";
    private List<List<Object>> objReturn = new ArrayList<>();

    public void save(List<Object> listObjToSave, List<Object> listProf) {
        List<List<Object>> obj = new ArrayList<>();
        if (listProf.get(0) instanceof Professor) {
            obj.add(0, listObjToSave);
            obj.add(1, listProf);
            
        } else if (listProf.get(0) instanceof ObjToSave) {

            obj.add(0, listObjToSave);
            obj.add(1, listProf);
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(path));
            ObjectOutputStream p = new ObjectOutputStream(out);
            p.writeObject(obj);
            p.close();

            System.out.println("howtodoinjava_demo.dat written successfully on disk.");

        } catch (Exception e) {
            System.out.println("Scrittura fallita " + e);
            e.printStackTrace();
        }

    }

    public List<List<Object>> openFile() {
        if (new File(this.path).exists()) {
            try {
                FileInputStream istream = new FileInputStream(path);
                ObjectInputStream p = new ObjectInputStream(istream);
                try {
                    this.objReturn = (List<List<Object>>) p.readObject();
                    p.close();
                    System.out.println("howtodoinjava_demo.dat read successfully on disk.");
                    return this.objReturn;

                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                    return null;
                }

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        } else {
            this.save(createNewEmptyList().get(0), createNewEmptyList().get(1));

            return this.openFile();

        }

    }

    private List<List<Object>> createNewEmptyList() {
        List<List<Object>> set = new ArrayList<>();

        List<Object> tempListProf = new ArrayList<>();
        List<Object> tempListObj = new ArrayList<>();

        for (ListProfessor p : ListProfessor.values()) {
            tempListObj
                    .add((Object) new ObjToSave(new PersonImpl(p.getName(), p.getSurname()), null, null, null, null));
        }
        set.add(0,tempListObj);

        for (ListProfessor p : ListProfessor.values()) {
            List<Courses> c = new ArrayList<>();
            for (ListCourses courses : p.getCourses()) {
                c.add(new CoursesImpl(courses.getValue(), courses.getType()));
            }
            tempListProf.add(new ProfessorImpl(new PersonImpl(p.getName(), p.getSurname()), c));
        }
        set.add(1,tempListProf);
        
        return set;

    }

    public List<Object> getListProfLinkedCourses() {
        List<Object> tempProf = new ArrayList<>();
        if (this.objReturn.isEmpty())
            this.openFile();
        tempProf = this.objReturn.get(1);
        return tempProf;
    }

    public List<Object> getListObjToSave() {
        List<Object> temp = new ArrayList<>();
        if (this.objReturn.isEmpty())
            this.openFile();
        temp = this.objReturn.get(0);
        return temp;
    }

}
