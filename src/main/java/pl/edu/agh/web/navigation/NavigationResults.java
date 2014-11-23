package pl.edu.agh.web.navigation;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
public enum NavigationResults {

    RELOAD_PAGE(""),

    INDEX("Index"),
    LOG_IN_PAGE("LogInPage"),
    SIGN_IN_PAGE("SignInPage"),

    MY_PANEL_PAGE("MyPanelPage"),
    MY_ACCOUNT_PAGE("MyAccountPage"),
    EDIT_MY_ACCOUNT_PAGE("EditMyAccountPage"),
    CHANGE_PASSWORD_PAGE("ChangePasswordPage"),
    MY_PREFERENCES_PAGE("MyPreferencesPage"),

    ADD_LOCATION_PAGE("AddLocationPage"),
    SHOW_ALL_LOCATIONS_PAGE("ShowAllLocationsPage"),
    SHOW_MY_LOCATIONS_PAGE("ShowMyLocationsPage"),
    SHOW_LOCATION_DESCRIPTION_PAGE("ShowLocationDescriptionPage"),
    ADD_LOCATION_COMMENT("AddLocationCommentPage"),

    NEW_TRIP_PAGE("NewTripPage"),
    SHOW_TRIPS_PAGE("ShowTripsPage");

    private final String navigation;

    private NavigationResults(String navigation) {
        this.navigation = navigation;
    }

    public String getNavigation() {
        return navigation;
    }
}
