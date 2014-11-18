package pl.edu.agh.web.beans.menus;

import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "mainPageMenuBean")
@SessionScoped
public class MainPageMenuBean {

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
        return NavigationResults.INDEX.getNavigation();
    }
}
