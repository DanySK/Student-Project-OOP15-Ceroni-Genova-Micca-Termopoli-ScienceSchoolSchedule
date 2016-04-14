package Model;

public class RoomImpl implements Room {
    
    protected String nameRoom;
    
    public RoomImpl(final String name){
        this.nameRoom = name;
    }


    @Override
    public String getNameRoom() {
        // TODO Auto-generated method stub
        return this.nameRoom;
    }

}
