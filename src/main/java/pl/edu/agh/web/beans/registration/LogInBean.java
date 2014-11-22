package pl.edu.agh.web.beans.registration;

import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.FormValidationErrorMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "logInBean")
@RequestScoped
public class LogInBean extends BaseBean implements Serializable {

    private String login;
    private String password;

    public String logInAction() {
        refreshPageData();
        if(StringTools.isNullOrEmpty(getLogin())) {
            addErrorMessage(FormValidationErrorMessages.LOGIN_IS_REQUIRED);
        }
        if(StringTools.isNullOrEmpty(getPassword())) {
            addErrorMessage(FormValidationErrorMessages.PASSWORD_IS_REQUIRED);
        }
        if(!isErrorMessageEmpty()) {
            return NavigationResults.RELOAD_PAGE.getNavigation();
        }

        String token = null;
        try {
            getSessionBean().setUserToken(getSessionBean().getSessionManagementService().loginUser(getLogin(), getPassword(), getSessionBean().getUserToken()));
            getSessionBean().getDataCacheService().initializeCache(getSessionBean().getUserToken());
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.MY_PANEL_PAGE);
    }

    //<editor-fold desc="Getters and Setters">
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
    //</editor-fold>
}
