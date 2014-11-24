package pl.edu.agh.services.serializers.trips;

import pl.edu.agh.domain.trips.Trip;
import pl.edu.agh.services.serializers.common.ResponseSerializer;
import pl.edu.agh.services.serializers.common.ResponseStatus;
import pl.edu.agh.web.messages.ErrorMessages;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
public class TripResponseSerializer extends ResponseSerializer {

    private Trip result;

    public TripResponseSerializer() {
    }

    public TripResponseSerializer(ResponseStatus status, List<ErrorMessages> errorMessage, Trip result) {
        super(status, errorMessage);
        this.result = result;
    }

    @Override
    public Trip getResult() {
        return result;
    }

    public void setResult(Trip result) {
        this.result = result;
    }
}
