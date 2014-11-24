package pl.edu.agh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.domain.trips.TripDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
@Service
public class DataCacheService {

    private enum LocationComparator implements Comparator<Location> {
        NEWEST {
            @Override
            public int compare(Location o1, Location o2) {
                return o1.getCreationDate().compareTo(o2.getCreationDate());
            }
        },
        TOP_RATED {
            @Override
            public int compare(Location o1, Location o2) {
                return (int) (o1.getRating() * 100 - o2.getRating() * 100);
            }
        };
    }

    private UsersManagementService usersManagementService;
    private LocationsManagementService locationsManagementService;
    private TripsManagementService tripsManagementService;

    private List<Trip> myTrips = new ArrayList<>();
    private List<Location> allLocations = new ArrayList<>();
    private List<Location> topRatedLocations = new ArrayList<>();
    private List<Location> newestLocations = new ArrayList<>();
    private List<Location> privateLocations = new ArrayList<>();
    private Location selectedLocation;
    private Trip selectedTrip;
    private TripDay selectedTripDay;

    @Autowired
    public DataCacheService(UsersManagementService usersManagementService, LocationsManagementService locationsManagementService, TripsManagementService tripsManagementService) {
        this.usersManagementService = usersManagementService;
        this.locationsManagementService = locationsManagementService;
        this.tripsManagementService = tripsManagementService;
    }

    public void initializeCache(String token) throws Exception {
        setAllLocations(locationsManagementService.getAllLocations(token));
        setPrivateLocations(locationsManagementService.getAllPrivateLocations(token));
        setTopRatedLocations(getSortedCollection(allLocations, LocationComparator.TOP_RATED));
        setNewestLocations(getSortedCollection(allLocations, LocationComparator.NEWEST));
        setMyTrips(tripsManagementService.getMyTripsList(token));
    }

    //<editor-fold desc="Getter And Setters">
    public List<Location> getAllLocations() throws Exception {
        return allLocations;
    }

    public void setAllLocations(List<Location> allLocations) {
        this.allLocations = allLocations != null ? allLocations : new ArrayList<>();
    }

    public List<Location> getTopRatedLocations() {
        return topRatedLocations;
    }

    public void setTopRatedLocations(List<Location> topRatedLocations) {
        this.topRatedLocations = topRatedLocations;
    }

    public List<Location> getNewestLocations() {
        return newestLocations;
    }

    public void setNewestLocations(List<Location> newestLocations) {
        this.newestLocations = newestLocations;
    }

    public List<Location> getPrivateLocations() {
        return privateLocations;
    }

    public void setPrivateLocations(List<Location> privateLocations) {
        this.privateLocations = privateLocations != null ? privateLocations : new ArrayList<>();
    }

    public Location getSelectedLocation(Long id, String userToken) throws Exception {
        if (selectedLocation == null) {
            selectedLocation = locationsManagementService.getLocationByIdAllData(id, userToken);
        }
        return selectedLocation;
    }

    public void setSelectedLocation(Location selectedLocation) {
        this.selectedLocation = selectedLocation;
    }

    public List<Trip> getMyTrips() {
        return myTrips;
    }

    public void setMyTrips(List<Trip> myTrips) {
        this.myTrips = myTrips != null ? myTrips : new ArrayList<>();
    }

    public Trip getSelectedTrip(Long id, String userToken) throws Exception {
        if(selectedTrip == null) {
            selectedTrip = tripsManagementService.getTripById(id, userToken);
        }
        return selectedTrip;
    }

    public void setSelectedTrip(Trip selectedTrip) {
        this.selectedTrip = selectedTrip;
    }

    public TripDay getSelectedTripDay(Long id, String userToken) throws Exception {
        if(selectedTripDay == null) {
            selectedTripDay = tripsManagementService.getTripDayByIdAllData(id, userToken);
        }
        return selectedTripDay;
    }

    public void setSelectedTripDay(TripDay selectedTripDay) {
        this.selectedTripDay = selectedTripDay;
    }
    //</editor-fold>

    //<editor-fold desc="Helper Methods">
    private List<Location> getSortedCollection(List<Location> locationsList, Comparator<Location> comparator) {
        List<Location> locations = new ArrayList<>(locationsList);
        Collections.sort(locations, comparator);
        Collections.reverse(locations);
        return locations;
    }
    //</editor-fold>

    //<editor-fold desc="Refreshing Data">
    public void refreshRequestData() {
        setSelectedLocation(null);
        setSelectedTrip(null);
        setSelectedTripDay(null);
    }

    public void refreshSessionData(String token) throws Exception {
        refreshRequestData();
        setAllLocations(null);
        setMyTrips(null);
        initializeCache(token);
    }
    //</editor-fold>

}
