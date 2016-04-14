package Model;

public class ClassRoom extends RoomImpl{
    
    private int seats;
    private String location;

    public ClassRoom(String name, final int seats, final String location) {
        super(name);
        // TODO Auto-generated constructor stub
        this.seats = seats;
        this.location = location;
    }
    
    public int getSeats(){  
        return this.seats;
    }
    
    public String getLocation(){
        return this.location;
    }

}
