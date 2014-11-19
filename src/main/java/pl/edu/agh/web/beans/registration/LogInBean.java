package pl.edu.agh.web.beans.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.services.SessionManagementService;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.FormValidationErrorMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "logInBean")
@ViewScoped
@Component
public class LogInBean extends BaseBean implements Serializable {

    @Autowired
    private SessionManagementService sessionManagementService;
    private String login;
    private String password;

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

    public SessionManagementService getSessionManagementService() {
        return sessionManagementService;
    }

    public void setSessionManagementService(SessionManagementService sessionManagementService) {
        this.sessionManagementService = sessionManagementService;
    }

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
            getSessionBean().setUserToken(getSessionManagementService().loginUser(getLogin(), getPassword(), getSessionBean().getUserToken()));
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.MY_PANEL_PAGE);
    }
}
