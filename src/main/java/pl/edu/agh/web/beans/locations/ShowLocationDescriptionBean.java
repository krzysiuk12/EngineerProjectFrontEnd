package pl.edu.agh.web.beans.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.DataCacheService;
import pl.edu.agh.services.LocationsManagementService;
import pl.edu.agh.web.beans.ApplicationBean;
import pl.edu.agh.web.beans.common.BaseBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
@ManagedBean(name = "showLocationDescriptionBean")
@RequestScoped
@Component
public class ShowLocationDescriptionBean extends BaseBean {

    @Autowired
    private DataCacheService dataCacheService;
    private LocationsManagementService locationsManagementService;
    private Location location;
    private Long id;

    public Location getLocation() {
        try {
            location = dataCacheService.getSelectedLocation(getSessionBean().getSelectedLocationId(), getSessionBean().getUserToken());
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
        return location.getCreatedByAccount() != null ? location.getCreatedByAccount().getLogin() : ApplicationBean.ADMINISTRATOR_USER;
    }

    public boolean isUrlRedirectionEnabled() {
        return location.getUrl() != null;
    }

    public boolean isLocationAvailable() {
        return location.getStatus() == Location.Status.AVAILABLE;
    }

    public boolean isLocationUnavailable() {
        return location.getStatus() == Location.Status.UNAVAILABLE;
    }

    public boolean isLocationRemoved() {
        return location.getStatus() == Location.Status.REMOVED;
    }

    public boolean isCommentListAvailable() {
        return location.getComments() != null && !location.getComments().isEmpty();
    }

}
