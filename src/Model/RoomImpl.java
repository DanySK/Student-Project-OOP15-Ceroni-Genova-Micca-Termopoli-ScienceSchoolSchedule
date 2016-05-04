package Model;

public class RoomImpl implements Room {
    
    protected String nameRoom;
    
    public RoomImpl(final String name){
        this.nameRoom = name;
    }

    public String getNameRoom() {
        
        return this.nameRoom;
    }

}
