package pl.edu.agh.web.messages;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
public enum InfoMessages implements BaseMessage {

    ACCOUNT_SUCCESSFULLY_CREATED,
    PASSWORD_SUCCESSFULLY_CHANGED,
    COMMENT_SUCCESSFULLY_ADDED;

    @Override
    public String getMessageKey() {
        return name();
    }

}
