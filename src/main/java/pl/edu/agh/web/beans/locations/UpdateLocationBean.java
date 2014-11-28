package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.ErrorMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-26.
 */
@ManagedBean(name = "updateLocationBean")
@ViewScoped
public class UpdateLocationBean extends BaseBean {

    private Location location;

    public Location getLocation() {
        if(location == null) {
            try {
                location = getSessionBean().getDataCacheService().getSelectedLocation(getSessionBean().getSelectedLocationId(), getSessionBean().getUserToken());
            } catch(Exception ex) {
                processRequestException(ex);
            }
        }
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String updateLocationAction() {
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
            getSessionBean().getLocationsManagementService().updateLocation(getLocation().getId(), getLocation().getName(), getLocation().getDescription(), getLocation().getUrl(), getLocation().getStatus(), getLocation().getLatitude(), getLocation().getLongitude(), getLocation().getAddress().getStreet(), getLocation().getAddress().getPostalCode(), getLocation().getAddress().getCity(), getLocation().getAddress().getCountry(), getSessionBean().getUserToken());
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }

}
