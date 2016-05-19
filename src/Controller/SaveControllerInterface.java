package Controller;

public interface SaveControllerInterface {

    void save(ObjToSave obj);

    void openFile();
    void createNewEmptyList();


    void reset();

    ObjToSave getObjToSave();

}