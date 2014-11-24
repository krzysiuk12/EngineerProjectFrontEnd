package pl.edu.agh.web.beans;

import pl.edu.agh.domain.useraccounts.UserAccount;
import pl.edu.agh.services.*;
import pl.edu.agh.web.messages.BaseMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-10-19.
 */
@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {

    private UsersManagementService usersManagementService = new UsersManagementService();
    private LocationsManagementService locationsManagementService = new LocationsManagementService();
    private TripsManagementService tripsManagementService = new TripsManagementService();
    private SessionManagementService sessionManagementService = new SessionManagementService();
    private DataCacheService dataCacheService = new DataCacheService(getUsersManagementService(), getLocationsManagementService(), getTripsManagementService());

    private UserAccount loggedUserAccount;
    private String userToken;
    protected List<BaseMessage> errorMessages = new ArrayList<>();
    protected List<BaseMessage> infoMessages = new ArrayList<>();
    protected Long selectedLocationId;
    protected Long selectedTripId;

    //<editor-fold desc="Getters and Setters">
    public UserAccount getLoggedUserAccount() {
        return loggedUserAccount;
    }

    public void setLoggedUserAccount(UserAccount loggedUserAccount) {
        this.loggedUserAccount = loggedUserAccount;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public List<BaseMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<BaseMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public List<BaseMessage> getInfoMessages() {
        return infoMessages;
    }

    public void setInfoMessages(List<BaseMessage> infoMessages) {
        this.infoMessages = infoMessages;
    }

    public Long getSelectedLocationId() {
        return selectedLocationId;
    }

    public void setSelectedLocationId(Long selectedLocationId) {
        this.selectedLocationId = selectedLocationId;
    }

    public Long getSelectedTripId() {
        return selectedTripId;
    }

    public void setSelectedTripId(Long selectedTripId) {
        this.selectedTripId = selectedTripId;
    }
    //</editor-fold>

    //<editor-fold desc="Services Getters and Setters">
    public DataCacheService getDataCacheService() {
        if(dataCacheService == null) {
            dataCacheService = new DataCacheService(getUsersManagementService(), getLocationsManagementService(), getTripsManagementService());
        }
        return dataCacheService;
    }

    public void setDataCacheService(DataCacheService dataCacheService) {
        this.dataCacheService = dataCacheService;
    }

    public UsersManagementService getUsersManagementService() {
        if(usersManagementService == null) {
            usersManagementService = new UsersManagementService();
        }
        return usersManagementService;
    }

    public void setUsersManagementService(UsersManagementService usersManagementService) {
        this.usersManagementService = usersManagementService;
    }

    public LocationsManagementService getLocationsManagementService() {
        if(locationsManagementService == null) {
            locationsManagementService = new LocationsManagementService();
        }
        return locationsManagementService;
    }

    public void setLocationsManagementService(LocationsManagementService locationsManagementService) {
        this.locationsManagementService = locationsManagementService;
    }

    public SessionManagementService getSessionManagementService() {
        if(sessionManagementService == null) {
            sessionManagementService = new SessionManagementService();
        }
        return sessionManagementService;
    }

    public void setSessionManagementService(SessionManagementService sessionManagementService) {
        this.sessionManagementService = sessionManagementService;
    }

    public TripsManagementService getTripsManagementService() {
        if(tripsManagementService == null) {
            tripsManagementService = new TripsManagementService();
        }
        return tripsManagementService;
    }

    public void setTripsManagementService(TripsManagementService tripsManagementService) {
        this.tripsManagementService = tripsManagementService;
    }

    //</editor-fold>

    //<editor-fold desc="Data Refreshing">
    public void refreshRequestData() {
        setErrorMessages(new ArrayList<>());
        setInfoMessages(new ArrayList<>());
        getDataCacheService().refreshRequestData();
    }

    public void refreshSessionData() {

    }
    //</editor-fold>
}
