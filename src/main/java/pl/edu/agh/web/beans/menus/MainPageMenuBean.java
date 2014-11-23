package pl.edu.agh.web.beans.menus;

import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "mainPageMenuBean")
@SessionScoped
public class MainPageMenuBean extends BaseBean {

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

    public String showNewestLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_NEWEST_LOCATIONS_PAGE);
    }

    public String showTopRatedLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_TOP_RATED_LOCATIONS_PAGE);
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
            getSessionBean().getSessionManagementService().logoutUser(getSessionBean().getUserToken());
            getSessionBean().setUserToken(null);
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.INDEX);
    }
}
