package pl.edu.agh.exceptions.response;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class RequestDeniedException extends Exception {

    public RequestDeniedException() {
    }

    public RequestDeniedException(String message) {
        super(message);
    }

    public RequestDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

}
