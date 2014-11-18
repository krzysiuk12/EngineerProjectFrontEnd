package pl.edu.agh.domain.useraccounts;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import pl.edu.agh.domain.common.implementation.VersionedBaseObject;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-05-30.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"versionNumber", "token", "userGroup"})
public class UserAccount extends VersionedBaseObject {

    public enum Status {
        CREATED,
        ACTIVE,
        LOCKED_OUT,
        TURNED_OFF,
        REMOVED
    }

    private String token;
    private String login;
    private String password;
    private String email;
    private Status status;
    private boolean passwordChangeRequired;
    private Date lastPasswordChangeDate;
    private int invalidSignInAttemptsCounter;
    private int lockoutCounter;
    private Individual individual;

    public UserAccount() {
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isPasswordChangeRequired() {
        return passwordChangeRequired;
    }

    public void setPasswordChangeRequired(boolean passwordChangeRequired) {
        this.passwordChangeRequired = passwordChangeRequired;
    }

    public Date getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(Date lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public int getInvalidSignInAttemptsCounter() {
        return invalidSignInAttemptsCounter;
    }

    public void setInvalidSignInAttemptsCounter(int invalidSignInAttemptsCounter) {
        this.invalidSignInAttemptsCounter = invalidSignInAttemptsCounter;
    }

    public int getLockoutCounter() {
        return lockoutCounter;
    }

    public void setLockoutCounter(int lockoutCounter) {
        this.lockoutCounter = lockoutCounter;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
