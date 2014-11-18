package pl.edu.agh.services;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.serializers.google.GoogleGeocodeRequestSerializer;
import pl.edu.agh.services.serializers.locations.LocationResponseSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
public class GoogleManagementService extends BaseService {

    public Location getLocationFromAddress(String address, String region, String components, String token) throws Exception {
        GoogleGeocodeRequestSerializer googleGeocodeRequestSerializer = new GoogleGeocodeRequestSerializer(address, region, components);
        LocationResponseSerializer rs = executeHttpPostRequest(ServerPaths.getLocationFromAddressRequestPath(), token, googleGeocodeRequestSerializer, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

    public Location getLocationCoordinatesFromAddress(String address, String region, String components, String token) throws Exception {
        GoogleGeocodeRequestSerializer googleGeocodeRequestSerializer = new GoogleGeocodeRequestSerializer(address, region, components);
        LocationResponseSerializer rs = executeHttpPostRequest(ServerPaths.getCoordinatesFromAddressRequestPath(), token, googleGeocodeRequestSerializer, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

}
