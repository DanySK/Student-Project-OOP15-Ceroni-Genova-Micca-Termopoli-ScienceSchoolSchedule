package Controller;

/**
 * @author Massimiliano Micca
 *
 */

public interface SaveControllerInterface {

    /**
     * this method is for restore the default data
     * never used.
     */
    public void reset();

    /**
     * save a ObjToSave in a file
     * @param obj
     */
    public void save(ObjToSave obj);

    /**
     * get ObjToSave from file
     * @return
     */
    public ObjToSave getObjToSave();

}