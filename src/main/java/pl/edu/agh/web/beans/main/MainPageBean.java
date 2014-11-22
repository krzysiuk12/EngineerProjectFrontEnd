package pl.edu.agh.web.beans.main;

import org.springframework.stereotype.Component;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "mainPageBean")
@SessionScoped
@Component
public class MainPageBean extends BaseBean implements Serializable {

    public String logInAction() {
        refreshPageData();
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }

    public String signInAction() {
        refreshPageData();
        return NavigationResults.SIGN_IN_PAGE.getNavigation();
    }

}
