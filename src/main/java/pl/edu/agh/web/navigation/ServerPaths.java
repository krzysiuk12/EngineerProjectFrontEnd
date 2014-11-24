package pl.edu.agh.web.navigation;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class ServerPaths {

    private static final String SERVER_PATH = "http://localhost:8081";
    private static final String LOCATIONS_SERVER_PATH = SERVER_PATH + "/locations";
    private static final String SESSION_SERVER_PATH = SERVER_PATH + "/sessions";
    private static final String USERS_SERVER_PATH = SERVER_PATH + "/users";
    private static final String GEOCODE_GOOGLE_SERVER_PATH = SERVER_PATH + "/googleapi/geocode";
    private static final String COORDINATES_SERVER_PATH = SERVER_PATH + "/coordinates";
    private static final String ADD_NEW_PRIVATE_LOCATION_SERVER_PATH = LOCATIONS_SERVER_PATH + "/private";
    private static final String LOGIN_SESSION_SERVER_PATH = SESSION_SERVER_PATH + "/login";
    private static final String LOGOUT_SESSION_SERVER_PATH = SESSION_SERVER_PATH + "/logout";
    private static final String TRIPS_SERVER_PATH = SERVER_PATH + "/trips";
    private static final String MY_TRIPS_SERVER_PATH = TRIPS_SERVER_PATH + "/my";
    private static final String TRIP_DAYS_SERVER_PATH = TRIPS_SERVER_PATH + "/day";


    public static String getAllLocationsRequestPath() {
        return LOCATIONS_SERVER_PATH;
    }

    public static String getAddNewLocationRequestPath() {
        return LOCATIONS_SERVER_PATH;
    }

    public static String getAddNewPrivateLocationRequestPath() {
        return ADD_NEW_PRIVATE_LOCATION_SERVER_PATH;
    }

    public static String getLocationByIdRequestPath(Long id) {
        return new StringBuilder(LOCATIONS_SERVER_PATH).append("/").append(id).toString();
    }

    public static String getLocationByIdAllDataRequestPath(Long id) {
        return new StringBuilder(getLocationByIdRequestPath(id)).append("/all").toString();
    }

    public static String getAllPrivateLocationsRequestPath() {
        return new StringBuilder(LOCATIONS_SERVER_PATH).append("/my").toString();
    }

    public static String getPrivateLocationRequestPath(Long id) {
        return new StringBuilder(getAllPrivateLocationsRequestPath()).append("/").append(id).toString();
    }

    public static String getChangeLocationStatusRequestPath(Long id) {
        return new StringBuilder(getLocationByIdRequestPath(id)).append("/status").toString();
    }

    public static String getDeleteLocationRequestPath(Long id) {
        return getLocationByIdRequestPath(id);
    }

    public static String getAddCommentRequestPath(Long id) {
        return new StringBuilder(getLocationByIdRequestPath(id)).append("/comment").toString();
    }

    public static String getLoginUserRequestPath() {
        return LOGIN_SESSION_SERVER_PATH;
    }

    public static String getLogoutUserRequestPath() {
        return LOGOUT_SESSION_SERVER_PATH;
    }

    public static String getAddNewUserAccountRequestPath() {
        return USERS_SERVER_PATH;
    }

    public static String getAllUserAccountsRequestPath() {
        return USERS_SERVER_PATH;
    }

    public static String getUserAccountByIdRequestPath(Long id) {
        return new StringBuilder(USERS_SERVER_PATH).append("/").append(id).toString();
    }

    public static String getUserAccountByIdAllDataRequestPath(Long id) {
        return new StringBuilder(getUserAccountByIdRequestPath(id)).append("/all").toString();
    }

    public static String getMyUserAccountRequestPath() {
        return new StringBuilder(USERS_SERVER_PATH).append("/my").toString();
    }

    public static String getMyUserAccountAllDataRequestPath() {
        return new StringBuilder(getMyUserAccountRequestPath()).append("/all").toString();
    }

    public static String getChangePasswordRequestPath() {
        return new StringBuilder(getMyUserAccountRequestPath()).append("/password").toString();
    }

    public static String getUpdateUserAccountRequestPath() {
        return new StringBuilder(getMyUserAccountRequestPath()).toString();
    }

    public static String getLocationFromAddressRequestPath() {
        return new StringBuilder(GEOCODE_GOOGLE_SERVER_PATH).append("/location").toString();
    }

    public static String getCoordinatesFromAddressRequestPath() {
        return new StringBuilder(GEOCODE_GOOGLE_SERVER_PATH).append("/coordinates").toString();
    }

    public static String getLocationFromIpAddressRequestPath() {
        return new StringBuilder(GEOCODE_GOOGLE_SERVER_PATH).append("/ip").toString();
    }

    public static String getLocationsInScopeRequestPath(double latitude, double longitude) {
        return new StringBuilder(COORDINATES_SERVER_PATH).append("/").append(latitude).append("/").append(longitude).append("/locations").toString();
    }

    public static String getLocationsInScopeRequestPath(double latitude, double longitude, double scope) {
        return new StringBuilder(COORDINATES_SERVER_PATH).append("/").append(latitude).append("/").append(longitude).append("/").append(scope).append("/locations").toString();
    }

    public static String getMyTripsRequestPath() {
        return MY_TRIPS_SERVER_PATH;
    }

    public static String getTripByIdRequestPath(Long id) {
        return new StringBuilder(TRIPS_SERVER_PATH).append("/").append(id).toString();
    }

    public static String getTripDayByIdRequestPath(Long id) {
        return new StringBuilder(TRIP_DAYS_SERVER_PATH).append("/").append(id).toString();
    }
}
