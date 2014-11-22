package pl.edu.agh.web.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "applicationBean")
@ApplicationScoped
public class ApplicationBean {

    public static final String ADMINISTRATOR_USER = "Administrator";

    public static final int GOOGLE_MAPS_DEFAULT_ZOOM = 15;

    public String getAdministratorUser() {
        return ADMINISTRATOR_USER;
    }

    public int getGoogleMapsDefaultZoom() {
        return GOOGLE_MAPS_DEFAULT_ZOOM;
    }
}
