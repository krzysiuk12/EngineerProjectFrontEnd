package pl.edu.agh.web.beans.trips;

import com.googlecode.gmaps4jsf.component.map.Map;
import com.googlecode.gmaps4jsf.component.marker.Marker;
import com.googlecode.gmaps4jsf.component.window.HTMLInformationWindow;
import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.domain.trips.TripDay;
import pl.edu.agh.domain.trips.TripDayLocation;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.Collections;

/**
 * Created by Krzysztof Kicinger on 2014-11-27.
 */
@ManagedBean(name = "showTripDayDescriptionBean")
@ViewScoped
public class ShowTripDayDescriptionBean extends BaseBean {

    private Trip trip;
    private TripDay tripDay;
    private Map locationsMap;

    public Trip getTrip() {
        if(trip == null) {
            try {
                trip = getSessionBean().getDataCacheService().getSelectedTrip(getSessionBean().getSelectedTripId(), getSessionBean().getUserToken());
            } catch (Exception ex) {
                processRequestException(ex);
            }
        }
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public TripDay getTripDay() {
        if(tripDay == null) {
            try {
                tripDay = getSessionBean().getDataCacheService().getSelectedTripDay(getSessionBean().getSelectedTripDayId(), getSessionBean().getUserToken());
                Collections.sort(tripDay.getLocations(), (x, y) -> x.getOrdinal() - y.getOrdinal());
                Collections.sort(tripDay.getTripSteps(), (x, y) -> (int)(x.getId() - y.getId()));
            } catch (Exception ex) {
                processRequestException(ex);
            }
        }
        return tripDay;
    }

    public void setTripDay(TripDay tripDay) {
        this.tripDay = tripDay;
    }

    public Map getLocationsMap() {
        return locationsMap;
    }

    public void setLocationsMap(Map locationsMap) {
        this.locationsMap = locationsMap;
        int mapsize = locationsMap.getChildren().size();
        for (int index = mapsize - 1; index >= 0; index--) {
            locationsMap.getChildren().remove(index);
        }

        locationsMap.setLatitude(Double.toString(getTripDay().getStartLocation().getLatitude()));
        locationsMap.setLongitude(Double.toString(getTripDay().getStartLocation().getLongitude()));

        for (TripDayLocation tripDayLocation : getTripDay().getLocations()) {
            Marker mark = new Marker();
            mark.setLatitude(Double.toString(tripDayLocation.getLocation().getLatitude()));
            mark.setLongitude(Double.toString(tripDayLocation.getLocation().getLongitude()));
            HTMLInformationWindow htmlInformationWindow = new HTMLInformationWindow();
            htmlInformationWindow.setHtmlText(tripDayLocation.getLocation().getName());
            mark.getChildren().add(htmlInformationWindow);
            locationsMap.getChildren().add(mark);
        }
    }

    public String goToLocationDescriptionAction(Long id) {
        refreshPageData();
        getSessionBean().setSelectedLocationId(id);
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }

}
