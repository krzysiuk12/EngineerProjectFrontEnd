package pl.edu.agh.web.beans.main;

import pl.edu.agh.services.LocationsManagementService;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "mainPageBean")
@SessionScoped
public class MainPageBean implements Serializable {

    public String logInAction() {
        return NavigationResults.LOG_IN_PAGE.getNavigation();
    }

    public String signInAction() {
        return NavigationResults.SIGN_IN_PAGE.getNavigation();
    }

    public String learnMoreAction() throws Exception {
        new LocationsManagementService().getAllLocations("SYSTEM");
        return NavigationResults.MY_PANEL_PAGE.getNavigation();
    }

}
