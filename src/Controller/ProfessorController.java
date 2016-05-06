package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

import Model.ListProfessor;
import Model.PersonImpl;
import Model.Professor;
import Model.ProfessorImpl;

public class ProfessorController implements ProfessorControllerInterface {
    private final String path = System.getProperty("user.home") + System.getProperty("file.separator")
            + "SiencesSchoolSchedul.dat";
    private final Set<Professor> objProfessor = new HashSet<>();
    private Integer size = 0;

    public void save(Set<Professor> obj) {
        this.size = obj.size();
        try {
            FileOutputStream out = new FileOutputStream(new File(path));
            ObjectOutputStream p = new ObjectOutputStream(out);
            for (Object o : obj) {
                p.writeObject(o);
            }
            p.close();

            System.out.println("howtodoinjava_demo.dat written successfully on disk.");

        } catch (Exception e) {
            System.out.println("Scrittura fallita " + e);
            e.printStackTrace();
        }

    }

    public Set<Professor> openFile() {
        int i = 1;
        if (new File(this.path).exists()) {
            try {
                FileInputStream istream = new FileInputStream(path);
                ObjectInputStream p = new ObjectInputStream(istream);
                Professor obj;
                try {
                    obj = (Professor) p.readObject();
                    while (i < size) {
                        if (obj instanceof Professor) {
                            this.objProfessor.add(obj);
                        }
                        obj = (Professor) p.readObject();
                        i++;
                    }
                    p.close();
                    return this.objProfessor;
                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                    return null;
                }

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        } else {
            this.save(createNewEmptyList());
            return this.objProfessor;

        }

    }

    public Set<Professor> createNewEmptyList() {
        Set<Professor> tempList = new HashSet<>();
        for (ListProfessor p : ListProfessor.values()) {
            tempList.add(new ProfessorImpl(new PersonImpl(p.getName(), p.getSurname()), p.getCourses()));
        }
        return tempList;

    }

}
