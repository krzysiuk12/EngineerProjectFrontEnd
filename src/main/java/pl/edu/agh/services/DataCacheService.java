package pl.edu.agh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.domain.trips.Trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-19.
 */
@Service
public class DataCacheService {

    private UsersManagementService usersManagementService;
    private LocationsManagementService locationsManagementService;

    private List<Trip> myTrips = new ArrayList<>();
    private List<Location> allLocations = new ArrayList<>();
    private List<Location> privateLocations = new ArrayList<>();
    private Location selectedLocation;

    @Autowired
    public DataCacheService(UsersManagementService usersManagementService, LocationsManagementService locationsManagementService) {
        this.usersManagementService = usersManagementService;
        this.locationsManagementService = locationsManagementService;
    }

    public void initializeCache(String token) throws Exception {
        allLocations = locationsManagementService.getAllLocations(token);
        Collections.sort(getAllLocations(), new Comparator<Location>() {
            @Override
            public int compare(Location o1, Location o2) {
                return (int) (o1.getRating() * 10 - o2.getRating() * 10);
            }
        });
        privateLocations = locationsManagementService.getAllPrivateLocations(token);
    }

    public List<Location> getThreeMostRatedLocations() {
        return getAllLocations().subList(0, 3);
    }

    public List<Location> getThreePrivateLocations() {
        if (getPrivateLocations().size() > 3) {
            Collections.shuffle(getPrivateLocations());
            return getPrivateLocations().subList(0, 3);
        } else {
            return getPrivateLocations();
        }
    }

    public List<Location> getAllLocations() {
        return allLocations;
    }

    public List<Location> getPrivateLocations() {
        return privateLocations;
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

    public void refreshRequestData() {
        setSelectedLocation(null);
    }
}
