package Controller;

import java.util.List;
import java.util.Set;

import Model.Professor;
import Model.RoomImpl;

public interface ObjToSaveInterface {

    public List<RoomImpl> getListRoom();

    public void setListRoom(List<RoomImpl> listRoom);

    public List<Professor> getListProfessor();

    public void setListProfessor(List<Professor> listProfessor);

    public Set<Reservation> getListReservation();

    public void setListReservation(Set<Reservation> listReservation);

    public void clear();

    public boolean exist();
}