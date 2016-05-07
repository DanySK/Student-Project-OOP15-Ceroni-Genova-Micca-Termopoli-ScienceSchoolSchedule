package Controller;

import java.util.List;

public interface ProfessorControllerInterface {

    public void save(List<Object> listObjToSave , List<Object> listProf);

    public List<List<Object>> openFile();

    public List<Object> getListProfLinkedCourses();

    public List<Object> getListObjToSave();
}
