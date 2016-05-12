package Controller;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import Model.Professor;
import Model.RoomImpl;

public class ObjToSave implements ObjToSaveInterface, Serializable {

    private static final long serialVersionUID = 1L;
    private Set<RoomImpl> listRoom = new TreeSet<>();
    private Set<Professor> listProfessor = new TreeSet<>();
    private Set<Reservation> listReservation = new TreeSet<>();

    public ObjToSave(Set<RoomImpl> listRoom, Set<Professor> listProfessor, Set<Reservation> listReservation) {
        this.listReservation = listReservation;
        this.listProfessor = listProfessor;
        this.listRoom = listRoom;

    }

    public boolean exist() {
        if (this.listProfessor.isEmpty() || this.listRoom.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Set<RoomImpl> getListRoom() {
        return listRoom;
    }

    public void setListRoom(Set<RoomImpl> listRoom) {
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
