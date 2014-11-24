package pl.edu.agh.services.serializers.trips;

import pl.edu.agh.domain.trips.TripDay;
import pl.edu.agh.services.serializers.common.ResponseSerializer;
import pl.edu.agh.services.serializers.common.ResponseStatus;
import pl.edu.agh.web.messages.ErrorMessages;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-24.
 */
public class TripDayResponseSerializer extends ResponseSerializer {

    private TripDay result;

    public TripDayResponseSerializer() {
    }

    public TripDayResponseSerializer(ResponseStatus status, List<ErrorMessages> errorMessage, TripDay result) {
        super(status, errorMessage);
        this.result = result;
    }

    @Override
    public TripDay getResult() {
        return result;
    }

    public void setResult(TripDay result) {
        this.result = result;
    }

}
