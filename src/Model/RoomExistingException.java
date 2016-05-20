package Model;


public class RoomExistingException extends Exception{

    
    
    private static final long serialVersionUID = -1340084149194451394L;
    private final String message;
    
    public RoomExistingException(final String m){
        super();
        this.message = m;
    }
    
    public final String getMessage(){
        return this.message;
    }
    
    
    
    
}
