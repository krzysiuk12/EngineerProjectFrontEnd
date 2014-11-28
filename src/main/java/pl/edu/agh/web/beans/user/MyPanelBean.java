package pl.edu.agh.web.beans.user;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
@ManagedBean(name = "myPanelBean")
@ViewScoped
public class MyPanelBean extends BaseBean {

    private static final int MAX_PANEL_LIST_DATA = 3;

    public List<Location> getNewestLocations() {
        return getPanelData(getSessionBean().getDataCacheService().getNewestLocations());
    }

    public List<Location> getTopRatedLocations() {
        return getPanelData(getSessionBean().getDataCacheService().getTopRatedLocations());
    }

    public List<Location> getPrivateLocations() {
        return getPanelData(getSessionBean().getDataCacheService().getPrivateLocations());
    }

    public List<Trip> getMyTrips() {
        return getTripPanelData(getSessionBean().getDataCacheService().getMyTrips());
    }

    public boolean isNewestLocationsListRendered() {
        return !getNewestLocations().isEmpty();
    }

    public boolean isTopRatedLocationsListRendered() {
        return !getTopRatedLocations().isEmpty();
    }

    public boolean isPrivateLocationsListRendered() {
        return !getPrivateLocations().isEmpty();
    }

    public boolean isMyTripsListRendered() {
        return !getMyTrips().isEmpty();
    }

    public String goToTopRatedLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_TOP_RATED_LOCATIONS_PAGE);
    }

    public String goToNewestLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_NEWEST_LOCATIONS_PAGE);
    }

    public String goToPrivateLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_MY_LOCATIONS_PAGE);
    }

    public String goToMyTripsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_TRIPS_PAGE);
    }

    public String goToLocationDescriptionAction(Long id) {
        refreshPageData();
        getSessionBean().setSelectedLocationId(id);
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }

    public String goToTripDescriptionAction(Long id) {
        refreshPageData();
        getSessionBean().setSelectedTripId(id);
        return tryToNavigate(NavigationResults.SHOW_TRIP_DESCRIPTION_PAGE);
    }

    private List<Location> getPanelData(List<Location> locationLists) {
        return locationLists.size() > MAX_PANEL_LIST_DATA ? locationLists.subList(0, MAX_PANEL_LIST_DATA) : locationLists;
    }

    private List<Trip> getTripPanelData(List<Trip> tripList) {
        return tripList.size() > MAX_PANEL_LIST_DATA ? tripList.subList(0, MAX_PANEL_LIST_DATA) : tripList;
    }

}
