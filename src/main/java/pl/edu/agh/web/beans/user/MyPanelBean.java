package pl.edu.agh.web.beans.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.DataCacheService;
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
@Component
public class MyPanelBean extends BaseBean {

    @Autowired
    private DataCacheService dataCacheService;

    public DataCacheService getDataCacheService() {
        return dataCacheService;
    }

    public void setDataCacheService(DataCacheService dataCacheService) {
        this.dataCacheService = dataCacheService;
    }

    public List<Location> getTopRatedLocations() {
        return dataCacheService.getThreeMostRatedLocations();
    }

    public String goToTopRatedLocationsAction() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_ALL_LOCATIONS_PAGE);
    }

    public String goToNewestLocationsActions() {
        refreshPageData();
        return tryToNavigate(NavigationResults.SHOW_ALL_LOCATIONS_PAGE);
    }

    public String goToLocationDescription(Long id) {
        refreshPageData();
        getSessionBean().setSelectedLocationId(id);
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }
}
