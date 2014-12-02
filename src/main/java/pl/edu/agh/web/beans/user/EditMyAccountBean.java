package pl.edu.agh.web.beans.user;

import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.ErrorMessages;
import pl.edu.agh.web.messages.InfoMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-20.
 */
@ManagedBean(name = "editMyAccountBean")
@ViewScoped
public class EditMyAccountBean extends BaseBean {

    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        if(userAccount == null) {
            try {
                setUserAccount(getSessionBean().getUsersManagementService().getMyUserAccountByIdAllData(getSessionBean().getUserToken()));
            } catch(Exception ex) {
                processRequestException(ex);
            }
        }
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public String saveUserAccountAction() {
        refreshPageData();
        if(StringTools.isNullOrEmpty(getUserAccount().getEmail())) {
            addErrorMessage(ErrorMessages.INVALID_USER_EMAIL);
        }
        if(StringTools.isNullOrEmpty(getUserAccount().getIndividual().getFirstName())) {
            addErrorMessage(ErrorMessages.INVALID_INDIVIDUAL_FIRST_NAME);
        }
        if(StringTools.isNullOrEmpty(getUserAccount().getIndividual().getLastName())) {
            addErrorMessage(ErrorMessages.INVALID_INDIVIDUAL_LAST_NAME);
        }
        if(!isErrorMessageEmpty()) {
            return NavigationResults.RELOAD_PAGE.getNavigation();
        }
        try {
            getSessionBean().getUsersManagementService().updateUserAccount(getUserAccount().getEmail(), getUserAccount().getIndividual().getFirstName(), getUserAccount().getIndividual().getLastName(), getUserAccount().getIndividual().getCity(), getUserAccount().getIndividual().getCountry(), getUserAccount().getIndividual().getDescription(), getSessionBean().getUserToken());
            addInfoMessage(InfoMessages.USER_ACCOUNT_SUCCESSFULLY_UPDATED);
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.MY_ACCOUNT_PAGE);
    }

}
