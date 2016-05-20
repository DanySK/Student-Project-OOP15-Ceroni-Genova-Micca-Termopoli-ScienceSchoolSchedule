package Model;

public class InDayException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4825747454646609431L;
    private final String message;
    
    public InDayException (final String m){
        this.message =  m;
    }
    
    public final String getMessage(){
        return this.message;
    }
}
