package pl.edu.agh.exceptions.response;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class ZeroResultsException extends Exception {

    public ZeroResultsException() {
    }

    public ZeroResultsException(String message) {
        super(message);
    }

    public ZeroResultsException(String message, Throwable cause) {
        super(message, cause);
    }
}
