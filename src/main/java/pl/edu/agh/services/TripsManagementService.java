package pl.edu.agh.services;

import org.springframework.stereotype.Service;
import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.exceptions.response.*;
import pl.edu.agh.services.serializers.trips.TripsListSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Service
public class TripsManagementService extends BaseService {

    public List<Trip> getMyTripsList(String token) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        TripsListSerializer rs = executeHttpGetRequest(ServerPaths.getMyTripsRequestPath(), token, TripsListSerializer.class);
        return (List<Trip>) parseResponse(rs);
    }

}
