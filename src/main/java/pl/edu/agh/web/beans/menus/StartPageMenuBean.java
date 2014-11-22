package pl.edu.agh.web.beans.menus;

import org.springframework.stereotype.Component;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "startPageMenuBean")
@SessionScoped
@Component
public class StartPageMenuBean extends BaseBean {

    public String logInAction() {
        refreshPageData();
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }

    public String signInAction() {
        refreshPageData();
        return NavigationResults.SIGN_IN_PAGE.getNavigation();
    }


}
