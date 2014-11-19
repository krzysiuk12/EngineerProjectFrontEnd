package pl.edu.agh.web.messages;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
public enum ResponseErrorMessages implements BaseMessage {

    ZERO_RESULTS_RETURNED,
    ACCESS_DENIED,
    REQUEST_DENIED,
    UNKNOWN_ERROR;

    @Override
    public String getMessageKey() {
        return name();
    }


}
