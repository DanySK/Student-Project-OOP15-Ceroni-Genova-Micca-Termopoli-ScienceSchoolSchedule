package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import Model.Professor;
import Model.RoomImpl;

public class ObjToSave implements ObjToSaveInterface, Serializable {

    private static final long serialVersionUID = 1L;
    private List<RoomImpl> listRoom = new ArrayList<>();
    private List<Professor> listProfessor = new ArrayList<>();
    private Set<Reservation> listReservation = new TreeSet<>();

    public ObjToSave(List<RoomImpl> listRoom, List<Professor> listProfessor, Set<Reservation> listReservation) {
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

    public List<RoomImpl> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<RoomImpl> listRoom) {
        this.listRoom = listRoom;
    }

    public List<Professor> getListProfessor() {
        return listProfessor;
    }

    public void setListProfessor(List<Professor> listProfessor) {
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
