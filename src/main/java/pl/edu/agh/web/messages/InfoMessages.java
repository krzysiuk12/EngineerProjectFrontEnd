package pl.edu.agh.web.messages;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
public enum InfoMessages implements BaseMessage {

    ACCOUNT_SUCCESSFULLY_CREATED;

    @Override
    public String getMessageKey() {
        return name();
    }

}
