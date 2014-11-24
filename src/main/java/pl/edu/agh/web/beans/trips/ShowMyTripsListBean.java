package pl.edu.agh.web.beans.trips;

import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@ManagedBean(name = "showMyTripsListBean")
@ViewScoped
public class ShowMyTripsListBean extends BaseBean {

    private List<Trip> trips;

    public List<Trip> getTrips() {
        if(trips == null) {
            try {
                trips = getSessionBean().getDataCacheService().getMyTrips();
            } catch(Exception ex) {
                processRequestException(ex);
            }
        }
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public String goToTripDescriptionAction(Long id) {
        return tryToNavigate(NavigationResults.LOG_IN_PAGE);
    }
    
}
