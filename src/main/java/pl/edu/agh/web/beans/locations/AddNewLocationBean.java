package pl.edu.agh.web.beans.locations;

import com.googlecode.gmaps4jsf.component.map.Map;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.ErrorMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-25.
 */
@ManagedBean(name = "addNewLocationBean")
@ViewScoped
public class AddNewLocationBean extends BaseBean {

    private String address;
    private Location location;
    private Map map;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String searchAction() {
        refreshPageData();
        if(StringTools.isNullOrEmpty(getAddress())) {
            addErrorMessage(ErrorMessages.NO_SEARCH_ADDRESS);
        }
        if(!isErrorMessageEmpty()) {
            return NavigationResults.RELOAD_PAGE.getNavigation();
        }

        try {
            setLocation(getSessionBean().getGoogleManagementService().getLocationFromAddress(getAddress(), null, null, getSessionBean().getUserToken()));
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.RELOAD_PAGE);
    }

    public String addLocationAction() {
        refreshPageData();
        if(StringTools.isNullOrEmpty(getLocation().getName())) {
            addErrorMessage(ErrorMessages.INVALID_LOCATION_NAME);
        }
        if(StringTools.isNullOrEmpty(getLocation().getAddress().getCity())) {
            addErrorMessage(ErrorMessages.INVALID_ADDRESS_CITY);
        }
        if(StringTools.isNullOrEmpty(getLocation().getAddress().getCountry())) {
            addErrorMessage(ErrorMessages.INVALID_ADDRESS_COUNTRY);
        }
        if(!isErrorMessageEmpty()) {
            return NavigationResults.RELOAD_PAGE.getNavigation();
        }

        try {
            if(location.isUsersPrivate()) {
                getSessionBean().getLocationsManagementService().addNewPrivateLocation(getLocation().getName(), getLocation().getDescription(), getLocation().getUrl(), getLocation().getStatus(), getLocation().getLatitude(), getLocation().getLongitude(), getLocation().getAddress().getStreet(), getLocation().getAddress().getPostalCode(), getLocation().getAddress().getCity(), getLocation().getAddress().getCountry(), getSessionBean().getUserToken());
                getSessionBean().refreshSessionData(false, true, false);
                return tryToNavigate(NavigationResults.SHOW_MY_LOCATIONS_PAGE);
            } else {
                getSessionBean().getLocationsManagementService().addNewLocation(getLocation().getName(), getLocation().getDescription(), getLocation().getUrl(), getLocation().getStatus(), getLocation().getLatitude(), getLocation().getLongitude(), getLocation().getAddress().getStreet(), getLocation().getAddress().getPostalCode(), getLocation().getAddress().getCity(), getLocation().getAddress().getCountry(), getSessionBean().getUserToken());
                getSessionBean().refreshSessionData(true, false, false);
                return tryToNavigate(NavigationResults.SHOW_ALL_LOCATIONS_PAGE);
            }
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.RELOAD_PAGE);
    }
}
