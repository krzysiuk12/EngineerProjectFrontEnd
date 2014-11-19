package pl.edu.agh.web.beans.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.services.SessionManagementService;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "mainPageMenuBean")
@SessionScoped
@Component
public class MainPageMenuBean extends BaseBean {

    @Autowired
    private SessionManagementService sessionManagementService;

    public String homeAction() {
        return NavigationResults.MY_PANEL_PAGE.getNavigation();
    }

    public String showMyAccountAction() {
        return NavigationResults.MY_ACCOUNT_PAGE.getNavigation();
    }

    public String editMyAccountAction() {
        return NavigationResults.EDIT_MY_ACCOUNT_PAGE.getNavigation();
    }

    public String changePasswordAction() {
        return NavigationResults.CHANGE_PASSWORD_PAGE.getNavigation();
    }

    public String showMyPreferencesAction() {
        return NavigationResults.MY_PREFERENCES_PAGE.getNavigation();
    }

    public String showAllLocationsAction() {
        return NavigationResults.SHOW_ALL_LOCATIONS_PAGE.getNavigation();
    }

    public String showMyLocationsAction() {
        return NavigationResults.SHOW_MY_LOCATIONS_PAGE.getNavigation();
    }

    public String showLocationDescriptionAction() {
        return NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE.getNavigation();
    }

    public String addLocationAction() {
        return NavigationResults.ADD_LOCATION_PAGE.getNavigation();
    }

    public String createNewTripAction() {
        return NavigationResults.NEW_TRIP_PAGE.getNavigation();
    }

    public String showTripsAction() {
        return NavigationResults.SHOW_TRIPS_PAGE.getNavigation();
    }

    public String logoutAction() {
        refreshPageData();
        try {
            sessionManagementService.logoutUser(getSessionBean().getUserToken());
            getSessionBean().setUserToken(null);
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.INDEX);
    }
}
