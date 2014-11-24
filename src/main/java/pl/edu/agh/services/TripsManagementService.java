package pl.edu.agh.services;

import org.springframework.stereotype.Service;
import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.domain.trips.TripDay;
import pl.edu.agh.exceptions.response.*;
import pl.edu.agh.services.serializers.trips.TripResponseSerializer;
import pl.edu.agh.services.serializers.trips.TripsListResponseSerializer;
import pl.edu.agh.web.navigation.ServerPaths;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
@Service
public class TripsManagementService extends BaseService {

    public List<Trip> getMyTripsList(String token) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        TripsListResponseSerializer rs = executeHttpGetRequest(ServerPaths.getMyTripsRequestPath(), token, TripsListResponseSerializer.class);
        return (List<Trip>) parseResponse(rs);
    }

    public Trip getTripById(Long id, String token) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        TripResponseSerializer rs = executeHttpGetRequest(ServerPaths.getTripByIdRequestPath(id), token, TripResponseSerializer.class);
        return (Trip) parseResponse(rs);
    }

    public TripDay getTripDayByIdAllData(Long id, String token) throws ZeroResultsException, AccessDeniedException, RequestDeniedException, UnknownErrorException, FormValidationError {
        TripResponseSerializer rs = executeHttpGetRequest(ServerPaths.getTripByIdRequestPath(id), token, TripResponseSerializer.class);
        return (TripDay) parseResponse(rs);
    }
}
