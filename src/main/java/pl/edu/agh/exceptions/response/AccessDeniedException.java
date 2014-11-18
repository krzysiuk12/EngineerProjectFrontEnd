package pl.edu.agh.exceptions.response;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class AccessDeniedException extends Exception {

    public AccessDeniedException() {
    }

    public AccessDeniedException(String message) {
        super(message);
    }

    public AccessDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

}
