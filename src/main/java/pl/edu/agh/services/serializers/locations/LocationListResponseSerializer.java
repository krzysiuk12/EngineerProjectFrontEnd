package pl.edu.agh.services.serializers.locations;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.serializers.common.ResponseSerializer;

import java.util.List;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class LocationListResponseSerializer extends ResponseSerializer {

    private List<Location> result;

    public LocationListResponseSerializer() {
    }

    public List<Location> getResult() {
        return result;
    }

    public void setResult(List<Location> result) {
        this.result = result;
    }
}
