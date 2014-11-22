package pl.edu.agh.web.beans.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.services.UsersManagementService;
import pl.edu.agh.web.beans.common.BaseBean;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-20.
 */
@ManagedBean(name = "myAccountBean")
@ViewScoped
@Component
@Scope(value = "prototype")
public class MyAccountBean extends BaseBean {

    @Autowired
    private UsersManagementService usersManagementService;
    private UserAccount userAccount;

    public UserAccount getUserAccount() {
        if(userAccount == null) {
            try {
                setUserAccount(usersManagementService.getMyUserAccountByIdAllData(getSessionBean().getUserToken()));
            } catch(Exception ex) {
                processRequestException(ex);
            }
        }
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
