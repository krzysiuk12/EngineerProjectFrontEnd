package pl.edu.agh.services.serializers.trips;

import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.services.serializers.common.ResponseSerializer;
import pl.edu.agh.services.serializers.common.ResponseStatus;
import pl.edu.agh.web.messages.ErrorMessages;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
public class TripsListSerializer extends ResponseSerializer {

    private List<Trip> result;

    public TripsListSerializer() {
    }

    public TripsListSerializer(ResponseStatus status, List<ErrorMessages> errorMessage, List<Trip> result) {
        super(status, errorMessage);
        this.result = result;
    }

    @Override
    public List<Trip> getResult() {
        return result;
    }

    public void setResult(List<Trip> result) {
        this.result = result;
    }
}
