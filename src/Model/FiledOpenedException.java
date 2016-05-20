package Model;

public class FiledOpenedException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = -6742684089793536307L;
    
    public final String getMessage(){
        return "Attention, the file is already open!";
    }
    

}
