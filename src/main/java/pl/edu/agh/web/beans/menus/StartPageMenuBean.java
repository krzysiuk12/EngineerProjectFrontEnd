package pl.edu.agh.web.beans.menus;

import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "startPageMenuBean")
@SessionScoped
public class StartPageMenuBean {

    public String logInAction() {
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }

    public String signInAction() {
        return NavigationResults.SIGN_IN_PAGE.getNavigation();
    }


}
