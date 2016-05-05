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

public class ObjWorkers implements ObjWorkersInterface {

    private final String path = System.getProperty("user.home") + System.getProperty("file.separator")
            + "SiencesSchoolSchedul.dat";
    private final Set<ObjToSave> objList = new HashSet<>();
    private Integer size = 0;

    public void save(Set<ObjToSave> obj) {
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

    public Set<ObjToSave> openFile() {
        int i = 1;
        if (new File(this.path).exists()) {
            try {
                FileInputStream istream = new FileInputStream(path);
                ObjectInputStream p = new ObjectInputStream(istream);
                ObjToSave obj;
                try {
                    obj = (ObjToSave) p.readObject();
                    while (i < size) {
                        if (obj instanceof ObjToSave) {
                            this.objList.add(obj);
                        }
                        obj = (ObjToSave) p.readObject();
                        i++;
                    }
                    p.close();
                    return this.objList;
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
            return this.objList;

        }

    }

    public Set<ObjToSave> createNewEmptyList() {
        Set<ObjToSave> tempList = new HashSet<>();
        for (ListProfessor p : ListProfessor.values()) {
            tempList.add(new ObjToSave(new PersonImpl(p.getName(), p.getSurname()), null, null, null, null));
        }
        return tempList;

    }

}
