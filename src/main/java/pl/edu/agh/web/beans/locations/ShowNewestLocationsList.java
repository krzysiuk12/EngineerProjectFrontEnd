package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Location;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-23.
 */
@ManagedBean(name = "showNewestLocationsList")
@ViewScoped
public class ShowNewestLocationsList extends LocationsListBaseBean {

    private static final int MAX_NEWEST_LOCATIONS = 10;

    @Override
    public List<Location> getData() {
        try {
            return getNewestLocationList(getSessionBean().getDataCacheService().getNewestLocations());
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return null;
    }

    private List<Location> getNewestLocationList(List<Location> fullList) {
        return fullList.size() > MAX_NEWEST_LOCATIONS ? fullList.subList(0, MAX_NEWEST_LOCATIONS) : fullList;
    }

}
