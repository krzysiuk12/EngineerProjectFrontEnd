package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.LocationsManagementService;
import pl.edu.agh.web.beans.ApplicationBean;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
@ManagedBean(name = "showLocationDescriptionBean")
@ViewScoped
public class ShowLocationDescriptionBean extends BaseBean {

    private LocationsManagementService locationsManagementService;
    private Location location;
    private Long id;

    public Location getLocation() {
        try {
            location = getSessionBean().getDataCacheService().getSelectedLocation(getSessionBean().getSelectedLocationId(), getSessionBean().getUserToken());
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return location.getCreatedByAccount() != null ? getLocation().getCreatedByAccount().getLogin() : ApplicationBean.ADMINISTRATOR_USER;
    }

    public boolean isUrlRedirectionEnabled() {
        return getLocation().getUrl() != null;
    }

    public boolean isLocationAvailable() {
        return getLocation().getStatus() == Location.Status.AVAILABLE;
    }

    public boolean isLocationUnavailable() {
        return getLocation().getStatus() == Location.Status.UNAVAILABLE;
    }

    public boolean isLocationRemoved() {
        return getLocation().getStatus() == Location.Status.REMOVED;
    }

    public boolean isCommentListAvailable() {
        return location.getComments() != null && !getLocation().getComments().isEmpty();
    }

    public boolean isLocationRated() {
        return Double.compare(getLocation().getRating(), 0.0) > 0;
    }

    public String addLocationCommentAction() {
        refreshPageData();
        getSessionBean().setSelectedLocationId(getLocation().getId());
        return tryToNavigate(NavigationResults.ADD_LOCATION_COMMENT);
    }
}
