package pl.edu.agh.services.serializers.locations;

import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.services.serializers.common.ResponseSerializer;

/**
 * Created by Krzysztof Kicinger on 2014-11-17.
 */
public class LocationResponseSerializer extends ResponseSerializer {

    private Location result;

    public LocationResponseSerializer() {
    }

    public Location getResult() {
        return result;
    }

    public void setResult(Location result) {
        this.result = result;
    }
}
