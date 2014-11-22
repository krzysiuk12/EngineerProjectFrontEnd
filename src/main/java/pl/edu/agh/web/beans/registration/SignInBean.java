package pl.edu.agh.web.beans.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.services.UsersManagementService;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.tools.ValidationTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.FormValidationErrorMessages;
import pl.edu.agh.web.messages.InfoMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "signInBean")
@RequestScoped
@Component
public class SignInBean extends BaseBean implements Serializable {

    @Autowired
    private UsersManagementService usersManagementService;
    private String login;
    private String email;
    private String password;
    private String passwordConfirmation;
    private String firstName;
    private String lastName;

    //<editor-fold desc="Getters And Setters">
    public UsersManagementService getUsersManagementService() {
        return usersManagementService;
    }

    public void setUsersManagementService(UsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //</editor-fold>

    public String performSignInAction() {
        refreshPageData();
        validateForm();
        if(!isErrorMessageEmpty()) {
            return NavigationResults.RELOAD_PAGE.getNavigation();
        }
        try {
            usersManagementService.addNewUserAccount(getLogin(), getPassword(), getEmail(), getFirstName(), getLastName());
            addInfoMessage(InfoMessages.ACCOUNT_SUCCESSFULLY_CREATED);
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.LOG_IN_PAGE);
    }

    private void validateForm() {
        if(StringTools.isNullOrEmpty(getLogin())) {
            addErrorMessage(FormValidationErrorMessages.LOGIN_IS_REQUIRED);
        }
        if(StringTools.isNullOrEmpty(getEmail())) {
            addErrorMessage(FormValidationErrorMessages.EMAIL_IS_REQUIRED);
        } else {
            if(!ValidationTools.validateEmail(getEmail())) {
                addErrorMessage(FormValidationErrorMessages.EMAIL_IS_NOT_CORRECT);
            }
        }
        if(StringTools.isNullOrEmpty(getPassword())) {
            addErrorMessage(FormValidationErrorMessages.PASSWORD_IS_REQUIRED);
        }
        if(StringTools.isNullOrEmpty(getPasswordConfirmation())){
            addErrorMessage(FormValidationErrorMessages.CONFIRM_PASSWORD_IS_REQUIRED);
        }
        if(!getPassword().equals(getPasswordConfirmation())) {
            addErrorMessage(FormValidationErrorMessages.PASSWORD_AND_CONFIRM_PASSWORD_NOT_THE_SAME);
        }
        if(StringTools.isNullOrEmpty(getFirstName())){
            addErrorMessage(FormValidationErrorMessages.FIRST_NAME_IS_REQUIRED);
        } else {
            if(!ValidationTools.validateFirstName(getFirstName())){
                addErrorMessage(FormValidationErrorMessages.FIRST_NAME_IS_NOT_CORRECT);
            }
        }
        if(StringTools.isNullOrEmpty(getLastName())){
            addErrorMessage(FormValidationErrorMessages.LAST_NAME_IS_REQUIRED);
        } else {
            if(!ValidationTools.validateLastName(getLastName())){
                addErrorMessage(FormValidationErrorMessages.LAST_NAME_IS_NOT_CORRECT);
            }
        }
    }

    public String goToLogInPageAction() {
        refreshPageData();
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }
}
