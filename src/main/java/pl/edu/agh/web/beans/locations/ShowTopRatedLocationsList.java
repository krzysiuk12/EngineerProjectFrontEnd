package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Location;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-23.
 */
@ManagedBean(name = "showTopRatedLocationsList")
@ViewScoped
public class ShowTopRatedLocationsList extends LocationsListBaseBean {

    private static final int MAX_TOP_RATED_LOCATIONS = 10;

    @Override
    public List<Location> getData() {
        try {
            return getTopRatedLocationList(getSessionBean().getDataCacheService().getTopRatedLocations());
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return null;
    }

    private List<Location> getTopRatedLocationList(List<Location> fullList) {
        return fullList.size() > MAX_TOP_RATED_LOCATIONS ? fullList.subList(0, MAX_TOP_RATED_LOCATIONS) : fullList;
    }

}
