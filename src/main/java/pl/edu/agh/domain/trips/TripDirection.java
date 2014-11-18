package pl.edu.agh.domain.trips;

import pl.edu.agh.domain.common.implementation.VersionedBaseObject;

/**
 * Created by Krzysiu on 2014-09-14.
 */

public class TripDirection extends VersionedBaseObject {

    private int ordinal;
    private TripStep tripStep;
    private String distance;
    private String duration;
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;
    private String instruction;
    private TravelMode travelMode;

    public TripDirection() {
    }

    public Long getId() {
        return super.getId();
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public TripStep getTripStep() {
        return tripStep;
    }

    public void setTripStep(TripStep tripStep) {
        this.tripStep = tripStep;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Coordinate getStartCoordinate() {
        return startCoordinate;
    }

    public void setStartCoordinate(Coordinate startCoordinate) {
        this.startCoordinate = startCoordinate;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public void setEndCoordinate(Coordinate endCoordinate) {
        this.endCoordinate = endCoordinate;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }
}
