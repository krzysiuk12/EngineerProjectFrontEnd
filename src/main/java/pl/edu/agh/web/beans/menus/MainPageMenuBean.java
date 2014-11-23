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
        refreshPageData();
        return tryToNavigate(NavigationResults.MY_PANEL_PAGE);
    }

    public String showMyAccountAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.MY_ACCOUNT_PAGE);
    }

    public String editMyAccountAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.EDIT_MY_ACCOUNT_PAGE);
    }

    public String changePasswordAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.CHANGE_PASSWORD_PAGE);
    }

    public String showMyPreferencesAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.MY_PREFERENCES_PAGE);
    }

    public String showAllLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_ALL_LOCATIONS_PAGE);
    }

    public String showMyLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_MY_LOCATIONS_PAGE);
    }

    public String showLocationDescriptionAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }

    public String addLocationAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.ADD_LOCATION_PAGE);
    }

    public String createNewTripAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.NEW_TRIP_PAGE);
    }

    public String showTripsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_TRIPS_PAGE);
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
