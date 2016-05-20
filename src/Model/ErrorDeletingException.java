package Model;

public class ErrorDeletingException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 7892441289602774501L;
    private final String message;
    
    public ErrorDeletingException(final String m){
        super();
        this.message = m;
    }
    
    public final String getMessage(){
        return this.message;
    }
}
