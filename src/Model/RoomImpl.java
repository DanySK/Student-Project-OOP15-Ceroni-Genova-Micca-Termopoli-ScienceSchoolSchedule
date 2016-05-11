package Model;

import java.io.Serializable;

public class RoomImpl implements Room,Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    protected String nameRoom;
    
    public RoomImpl(final String name){
        this.nameRoom = name;
    }

    public String getNameRoom() {
        
        return this.nameRoom;
    }

}
