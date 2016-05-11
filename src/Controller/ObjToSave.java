package Controller;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import Model.Professor;
import Model.Room;

public class ObjToSave implements ObjToSaveInterface,Serializable  {

   
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Set<Room> listRoom = new HashSet<>();
    private Set<Professor> listProfessor = new HashSet<>();
    private Set<Reservation> listReservation = new HashSet<>();

    public ObjToSave(Set<Room> listRoom, Set<Professor> listProfessor, Set<Reservation> listReservation) {
        this.listReservation = listReservation;
        this.listProfessor = listProfessor;
        this.listRoom = listRoom;

    }
    
    public boolean exist(){
        if(this.listProfessor.isEmpty()|| this.listRoom.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public Set<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(Set<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public Set<Professor> getListProfessor() {
        return listProfessor;
    }

    public void setListProfessor(Set<Professor> listProfessor) {
        this.listProfessor = listProfessor;
    }

    public Set<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(Set<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public void clear() {
        this.listProfessor.clear();
        this.listReservation.clear();
        this.listRoom.clear();
    }

}
