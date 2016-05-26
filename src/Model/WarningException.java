package Model;

public class WarningException extends Exception {

    /**
    * 
    */
    private static final long serialVersionUID = 4512453331501755864L;
    private final String message;

    public WarningException(final String m) {
        super();
        this.message = m;
    }

    public final String getMessage() {
        return this.message;
    }
}
