package Model;

public class ErrorException extends Exception {

    /**
    * 
    */
    private static final long serialVersionUID = 1334396525055957672L;
    private final String message;

    public ErrorException(final String m) {
        super();
        this.message = m;
    }

    public final String getMessage() {
        return this.message;
    }
}
