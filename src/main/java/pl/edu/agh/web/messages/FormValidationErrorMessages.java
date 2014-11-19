package pl.edu.agh.web.messages;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
public enum FormValidationErrorMessages implements BaseMessage {

    LOGIN_IS_REQUIRED,
    PASSWORD_IS_REQUIRED,
    EMAIL_IS_REQUIRED,
    CONFIRM_PASSWORD_IS_REQUIRED,
    EMAIL_IS_NOT_CORRECT,
    PASSWORD_AND_CONFIRM_PASSWORD_NOT_THE_SAME,
    FIRST_NAME_IS_REQUIRED,
    LAST_NAME_IS_REQUIRED,
    FIRST_NAME_IS_NOT_CORRECT,
    LAST_NAME_IS_NOT_CORRECT;

    @Override
    public String getMessageKey() {
        return name();
    }
}
