package pl.edu.agh.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private String loggedUser = "Krzysztof Kicinger";
    private String currentMainTab;
    private String currentTab;

    public String getCurrentTab() {
        return currentTab;
    }

    public void setCurrentTab(String currentTab) {
        this.currentTab = currentTab;
    }

    public String getCurrentMainTab() {
        return currentMainTab;
    }

    public void setCurrentMainTab(String currentMainTab) {
        this.currentMainTab = currentMainTab;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

}
