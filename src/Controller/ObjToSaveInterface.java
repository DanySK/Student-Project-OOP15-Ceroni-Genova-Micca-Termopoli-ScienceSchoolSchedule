package Controller;

import java.util.List;

import Model.Professor;
import Model.RoomImpl;

/**
 * @author Massimiliano Micca
 *
 *this class is used to make a obj 
 */
public interface ObjToSaveInterface {

    /**
     * used for take a list of room from obj
     * 
     * @return
     */
    public List<RoomImpl> getListRoom();

    /**
     * used for set a list of room in a obj
     * @param listRoom
     */
    public void setListRoom(List<RoomImpl> listRoom);

    /**
     * used for take a list of professor from obj
     * @return
     */
    public List<Professor> getListProfessor();

    /**
     * used for set a list of professor in a obj
     * @param listProfessor
     */
    public void setListProfessor(List<Professor> listProfessor);

    /**
     * used for get a list of reservation in a obj
     * @return
     */
    public List<Reservation> getListReservation();

    /**
     * used for set a list of reservation in a obj
     * @param listReservation
     */
    public void setListReservation(List<Reservation> listReservation);

    /**
     * this method is never used but need to clear all list in default value
     */
    public void clear();

    /**
     * @return
     */
    public boolean exist();
}