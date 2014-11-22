package pl.edu.agh.web.beans.user;

import org.springframework.stereotype.Component;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.FormValidationErrorMessages;
import pl.edu.agh.web.messages.InfoMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-20.
 */
@ManagedBean(name = "changeMyPasswordBean")
@RequestScoped
@Component
public class ChangeMyPasswordBean extends BaseBean {

    private String currentPassword;
    private String newPassword;
    private String confirmNewPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }

    public String changePasswordAction() {
        refreshPageData();
        if(StringTools.isNullOrEmpty(getCurrentPassword())) {
            addErrorMessage(FormValidationErrorMessages.CHANGE_PASSWORD_CURRENT_PASSWORD);
        }
        if(StringTools.isNullOrEmpty(getNewPassword())) {
            addErrorMessage(FormValidationErrorMessages.CHANGE_PASSWORD_NEW_PASSWORD);
        }
        if(StringTools.isNullOrEmpty(getConfirmNewPassword())) {
            addErrorMessage(FormValidationErrorMessages.CHANGE_PASSWORD_CONFIRM_NEW_PASSWORD);
        }
        if(!getNewPassword().equals(getConfirmNewPassword())) {
            addErrorMessage(FormValidationErrorMessages.CHANGE_PASSWORD_NEW_AND_CONFIRM_NOT_EQUAL);
        }
        addInfoMessage(InfoMessages.PASSWORD_SUCCESSFULLY_CHANGED);
        return tryToNavigate(NavigationResults.MY_PANEL_PAGE);
    }

}
