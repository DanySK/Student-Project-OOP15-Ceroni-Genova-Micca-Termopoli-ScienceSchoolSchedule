package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.Professor;
import Model.RoomImpl;

public class ObjToSave implements ObjToSaveInterface, Serializable {

    private static final long serialVersionUID = 1L;
    private List<RoomImpl> listRoom = new ArrayList<>();
    private List<Professor> listProfessor = new ArrayList<>();
    private List<Reservation> listReservation = new ArrayList<>();

    public ObjToSave(List<RoomImpl> listRoom, List<Professor> listProfessor, List<Reservation> listReservation) {
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

    public List<Reservation> getListReservation() {
        return listReservation;
    }

    public void setListReservation(List<Reservation> listReservation) {
        this.listReservation = listReservation;
    }

    public void clear() {
        this.listProfessor.clear();
        this.listReservation.clear();
        this.listRoom.clear();
    }

}
