package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Location;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "showMyLocationsBean")
@ViewScoped
public class ShowMyLocationsBean extends MapLocationsBaseBean {

    @Override
    public List<Location> getData() {
        return getSessionBean().getDataCacheService().getPrivateLocations();
    }
}
