package pl.edu.agh.exceptions.response;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class UnknownErrorException extends Exception {

    public UnknownErrorException() {
    }

    public UnknownErrorException(String message) {
        super(message);
    }

    public UnknownErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}
