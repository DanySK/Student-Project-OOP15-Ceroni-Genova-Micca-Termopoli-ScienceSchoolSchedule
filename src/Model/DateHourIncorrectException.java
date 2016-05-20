package Model;

public class DateHourIncorrectException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 5863352576918120194L;
    private final String message;
    
    public DateHourIncorrectException(final String m){
        super();
        this.message = m;
    }
    
    public final String getMessage(){
        return this.message;
    }  
    
}
