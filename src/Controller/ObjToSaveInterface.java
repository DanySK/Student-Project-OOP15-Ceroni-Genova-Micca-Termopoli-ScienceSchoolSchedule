package Controller;

import java.util.Set;

import Model.Professor;
import Model.Room;

public interface ObjToSaveInterface {

    public Set<Room> getListRoom();

    public void setListRoom(Set<Room> listRoom);

    public Set<Professor> getListProfessor();

    public void setListProfessor(Set<Professor> listProfessor);

    public Set<Reservation> getListReservation();

    public void setListReservation(Set<Reservation> listReservation);

    public void clear();

    public boolean exist();
}