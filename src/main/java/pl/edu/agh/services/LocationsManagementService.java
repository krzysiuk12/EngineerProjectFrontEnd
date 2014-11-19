package pl.edu.agh.services;

import org.springframework.stereotype.Service;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.serializers.common.BaseResponseSerializer;
import pl.edu.agh.services.serializers.locations.LocationListResponseSerializer;
import pl.edu.agh.services.serializers.locations.LocationRequestSerializer;
import pl.edu.agh.services.serializers.locations.LocationResponseSerializer;
import pl.edu.agh.services.serializers.locations.LocationStatusChangeRequestSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
@Service
public class LocationsManagementService extends BaseService {

    public List<Location> getAllLocations(String token) throws Exception {
        LocationListResponseSerializer rs = executeHttpGetRequest(ServerPaths.getAllLocationsRequestPath(), token, LocationListResponseSerializer.class);
        return (List<Location>) parseResponse(rs);
    }

    public List<Location> getAllPrivateLocations(String token) throws Exception {
        LocationListResponseSerializer rs = executeHttpGetRequest(ServerPaths.getAllPrivateLocationsRequestPath(), token, LocationListResponseSerializer.class);
        return (List<Location>) parseResponse(rs);
    }

    public Location getLocationById(Long id, String token) throws Exception {
        LocationResponseSerializer rs = executeHttpGetRequest(ServerPaths.getLocationByIdRequestPath(id), token, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

    public Location getLocationByIdAllData(Long id, String token) throws Exception {
        LocationResponseSerializer rs = executeHttpGetRequest(ServerPaths.getLocationByIdAllDataRequestPath(id), token, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

    public Location getPrivateLocationById(Long id, String token) throws Exception {
        LocationResponseSerializer rs = executeHttpGetRequest(ServerPaths.getPrivateLocationRequestPath(id), token, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

    public boolean addNewLocation(String name, double latitude, double longitude, String city, String country, String token) throws Exception {
        LocationRequestSerializer locationRequestSerializer = new LocationRequestSerializer(name, latitude, longitude, city, country);
        BaseResponseSerializer rs = executeHttpPostRequest(ServerPaths.getAddNewLocationRequestPath(), token, locationRequestSerializer, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }

    public boolean addNewPrivateLocation(String name, double latitude, double longitude, String city, String country, String token) throws Exception {
        LocationRequestSerializer locationRequestSerializer = new LocationRequestSerializer(name, latitude, longitude, city, country);
        BaseResponseSerializer rs = executeHttpPostRequest(ServerPaths.getAddNewPrivateLocationRequestPath(), token, locationRequestSerializer, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }

    public Location changeLocationStatus(Long id, Location.Status previous, Location.Status newStatus, String token) throws Exception {
        LocationStatusChangeRequestSerializer locationStatusChangeRequestSerializer = new LocationStatusChangeRequestSerializer(previous, newStatus);
        LocationResponseSerializer rs = executeHttpGetRequest(ServerPaths.getChangeLocationStatusRequestPath(id), token, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

    public boolean deleteLocation(Long id, String token) throws Exception {
        BaseResponseSerializer rs = executeHttpDeleteRequest(ServerPaths.getDeleteLocationRequestPath(id), token, BaseResponseSerializer.class);
        return testResponseCorrectness(rs);
    }

}
