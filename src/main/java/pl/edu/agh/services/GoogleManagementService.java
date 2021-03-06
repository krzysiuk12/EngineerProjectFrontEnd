package pl.edu.agh.services;

import org.springframework.stereotype.Service;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.serializers.google.GoogleGeocodeRequestSerializer;
import pl.edu.agh.services.serializers.locations.LocationResponseSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

/**
 * Created by Krzysztof Kicinger on 2014-11-18.
 */
@Service
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

    public Location getLocationFromIpAddress(String token) throws Exception {
        LocationResponseSerializer rs = executeHttpGetRequest(ServerPaths.getLocationFromIpAddressRequestPath(), token, LocationResponseSerializer.class);
        return (Location) parseResponse(rs);
    }

}
