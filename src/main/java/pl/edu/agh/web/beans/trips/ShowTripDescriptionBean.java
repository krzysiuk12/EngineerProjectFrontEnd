package pl.edu.agh.web.beans.trips;

import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@ManagedBean(name = "showTripDescriptionBean")
@ViewScoped
public class ShowTripDescriptionBean extends BaseBean {

    private Trip trip;

    public Trip getTrip() {
        try {
            trip = getSessionBean().getDataCacheService().getSelectedTrip(getSessionBean().getSelectedTripId(), getSessionBean().getUserToken());
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String goToTripDayDescription(Long tripDayId) {
        refreshPageData();
        getSessionBean().setSelectedTripDayId(tripDayId);
        return tryToNavigate(NavigationResults.SHOW_TRIP_DAY_DESCRIPTION_PAGE);
    }

}
