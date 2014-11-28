package pl.edu.agh.domain.trips;


import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import pl.edu.agh.domain.common.implementation.VersionedBaseObject;
import pl.edu.agh.domain.locations.Location;

/**
 * Created by Krzysiu on 2014-09-14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TripDayLocation extends VersionedBaseObject {

    @JsonBackReference("tripday-tripdaylocation")
    private TripDay tripDay;
    private Location location;
    private int ordinal;

    public TripDayLocation() {
    }

    public TripDayLocation(TripDay tripDay, Location location, int ordinal) {
        this.tripDay = tripDay;
        this.location = location;
        this.ordinal = ordinal;
    }

    public TripDay getTripDay() {
        return tripDay;
    }

    public void setTripDay(TripDay tripDay) {
        this.tripDay = tripDay;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }
}
