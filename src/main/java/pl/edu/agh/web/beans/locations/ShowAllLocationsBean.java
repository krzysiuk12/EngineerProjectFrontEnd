package pl.edu.agh.web.beans.locations;

import com.googlecode.gmaps4jsf.component.eventlistener.EventListener;
import com.googlecode.gmaps4jsf.component.map.Map;
import com.googlecode.gmaps4jsf.component.marker.Marker;
import com.googlecode.gmaps4jsf.component.window.HTMLInformationWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.DataCacheService;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.FormValidationErrorMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "showAllLocationsBean")
@ViewScoped
@Component
public class ShowAllLocationsBean extends BaseBean {

    @Autowired
    private DataCacheService dataCacheService;
    private List<Location> locations;
    private Location selectedLocation;
    private Long selectedId;
    private Map map;

    public String getLocationName() {
        return getSelectedLocation().getName();
    }

    public String getLocationCity() {
        return getSelectedLocation().getAddress().getCity();
    }

    public String getLocationCountry() {
        return getSelectedLocation().getAddress().getCountry();
    }

    public List<Location> getLocations() {
        try {
            locations = dataCacheService.getAllLocations();
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Location getSelectedLocation() {
        try {
            selectedLocation = getLocations().get(0);
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return selectedLocation;
    }

    public void setSelectedLocation(Location selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public DataCacheService getDataCacheService() {
        return dataCacheService;
    }

    public void setDataCacheService(DataCacheService dataCacheService) {
        this.dataCacheService = dataCacheService;
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public void processClickForMarker() {
        System.out.println("HERE");
    }

    public void setMap(Map map) {
        this.map = map;
        int mapsize = map.getChildren().size();
        for (int index = mapsize - 1; index >= 0; index--) {
            map.getChildren().remove(index);
        }

        map.setLatitude(Double.toString(getSelectedLocation().getLatitude()));
        map.setLongitude(Double.toString(getSelectedLocation().getLongitude()));

        for (Location location : getLocations()) {
            Marker mark = new Marker();
            mark.setLatitude(Double.toString(location.getLatitude()));
            mark.setLongitude(Double.toString(location.getLongitude()));
            HTMLInformationWindow htmlInformationWindow = new HTMLInformationWindow();
            htmlInformationWindow.setHtmlText(getHtmlDescription(location.getName(), location.getStatus().name()));
            EventListener event = new EventListener();
            event.setEventName("click");
            event.setJsFunction("setLocationId(" + location.getId() + ")");
            mark.getChildren().add(htmlInformationWindow);
            mark.getChildren().add(event);
            map.getChildren().add(mark);
        }
    }

    public String getHtmlDescription(String name, String status) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<b>").append(name).append("</b>").append("</br>");
        stringBuilder.append("Status: ").append(status);
        return stringBuilder.toString();
    }

    public Map getMap() {
        return map;
    }

    public String goToShowDescription() {
        refreshPageData();
        if (getSelectedId() == null || getSelectedId() == 0) {
            addErrorMessage(FormValidationErrorMessages.NOT_SELECTED_LOCATION_ID);
        }
        getSessionBean().setSelectedLocationId(getSelectedId());
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }

}
