package Controller;

import java.util.Set;

public interface ObjWorkersInterface {

    public void save(Set<ObjToSave> obj);

    public Set<ObjToSave> openFile();
    public Set<ObjToSave> createNewEmptyList();

}