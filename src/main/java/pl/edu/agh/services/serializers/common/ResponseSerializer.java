package pl.edu.agh.services.serializers.common;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-15.
 */
public abstract class ResponseSerializer {

    private ResponseStatus status;
    private List<ErrorMessages> errorMessage;

    public ResponseSerializer() {
    }

    public ResponseSerializer(ResponseStatus status, List<ErrorMessages> errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public List<ErrorMessages> getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(List<ErrorMessages> errorMessage) {
        this.errorMessage = errorMessage;
    }

    public abstract Object getResult();

}
