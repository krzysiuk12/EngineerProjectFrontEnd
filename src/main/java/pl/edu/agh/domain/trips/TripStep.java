package pl.edu.agh.domain.trips;


import pl.edu.agh.domain.common.implementation.VersionedBaseObject;
import pl.edu.agh.domain.locations.Location;

import java.util.List;

/**
 * Created by Krzysiu on 2014-09-14.
 */
public class TripStep extends VersionedBaseObject {

    private TripDay tripDay;
    private Location startLocation;
    private Location endLocation;
    private String distance;
    private DistanceUnit distanceUnit;
    private String duration;
    private List<TripDirection> directions;

    public TripStep() {
    }

    public TripDay getTripDay() {
        return tripDay;
    }

    public void setTripDay(TripDay tripDay) {
        this.tripDay = tripDay;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public DistanceUnit getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(DistanceUnit distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<TripDirection> getDirections() {
        return directions;
    }

    public void setDirections(List<TripDirection> directions) {
        this.directions = directions;
    }
}
