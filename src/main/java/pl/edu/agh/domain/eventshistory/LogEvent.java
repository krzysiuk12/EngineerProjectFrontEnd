package pl.edu.agh.domain.eventshistory;


import pl.edu.agh.domain.common.implementation.BaseObject;
import pl.edu.agh.domain.useraccounts.UserAccount;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-05-30.
 */
public class LogEvent extends BaseObject {

    public enum Type {
        LOGIN_SUCCESSFUL,
        LOGIN_FAILED,
        LOGOUT
    }

    private UserAccount userAccount;
    private Date generatedOn;
    private Type type;
    private String sessionId;
    private String ipAddress;

    public LogEvent() {
    }
    public LogEvent(UserAccount generatedBy, Date generatedOn, Type type, String sessionId, String ipAddress) {
        this.userAccount = generatedBy;
        this.generatedOn = generatedOn;
        this.type = type;
        this.sessionId = sessionId;
        this.ipAddress = ipAddress;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Date getGeneratedOn() {
        return generatedOn;
    }
    public void setGeneratedOn(Date generatedOn) {
        this.generatedOn = generatedOn;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public String getSessionId() {
        return sessionId;
    }
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getIpAddress() {
        return ipAddress;
    }
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
