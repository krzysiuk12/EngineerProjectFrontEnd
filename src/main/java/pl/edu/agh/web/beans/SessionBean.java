package pl.edu.agh.web.beans;

import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.web.messages.BaseMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private UserAccount loggedUserAccount;
    private String userToken;
    protected List<BaseMessage> errorMessages = new ArrayList<>();
    protected List<BaseMessage> infoMessages = new ArrayList<>();


    public UserAccount getLoggedUserAccount() {
        return loggedUserAccount;
    }

    public void setLoggedUserAccount(UserAccount loggedUserAccount) {
        this.loggedUserAccount = loggedUserAccount;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public List<BaseMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<BaseMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<BaseMessage> getInfoMessages() {
        return infoMessages;
    }

    public void setInfoMessages(List<BaseMessage> infoMessages) {
        this.infoMessages = infoMessages;
    }
}
