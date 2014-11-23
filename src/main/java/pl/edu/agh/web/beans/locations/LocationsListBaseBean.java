package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-23.
 */
public abstract class LocationsListBaseBean extends BaseBean {

    private List<Location> locationList;

    public List<Location> getLocationList() {
        if(locationList == null) {
            locationList = getData();
        }
        return locationList;
    }

    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    public String goToLocationDescriptionAction(Long id) {
        refreshPageData();
        getSessionBean().setSelectedLocationId(id);
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }

    public abstract List<Location> getData();
}
