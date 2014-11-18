package pl.edu.agh.services;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.serializers.locations.LocationListResponseSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class CoordinatesManagementService extends BaseService {

    public List<Location> getLocationsInScope(double latitude, double longitude, String token) throws Exception {
        LocationListResponseSerializer rs = executeHttpGetRequest(ServerPaths.getLocationsInScopeRequestPath(latitude, longitude), token, LocationListResponseSerializer.class);
        return (List<Location>) parseResponse(rs);
    }

    public List<Location> getLocationsInScope(double latitude, double longitude, double scope, String token) throws Exception {
        LocationListResponseSerializer rs = executeHttpGetRequest(ServerPaths.getLocationsInScopeRequestPath(latitude, longitude, scope), token, LocationListResponseSerializer.class);
        return (List<Location>) parseResponse(rs);
    }

}
