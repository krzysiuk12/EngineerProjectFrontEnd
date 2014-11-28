package pl.edu.agh.domain.trips;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonManagedReference;
import pl.edu.agh.domain.common.implementation.VersionedBaseObject;
import pl.edu.agh.domain.locations.Location;

import java.util.Date;
import java.util.List;

/**
 * Created by Krzysiu on 2014-09-14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TripDay extends VersionedBaseObject {

    private Trip trip;
    @JsonManagedReference("tripday-tripdaylocation")
    private List<TripDayLocation> locations;
    @JsonManagedReference("tripday-tripstep")
    private List<TripStep> tripSteps;
    private Date date;
    private int dayNumber;
    private Date plannedStartTime;

    public TripDay() {
    }

    public Long getId() {
        return super.getId();
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public List<TripDayLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<TripDayLocation> locations) {
        this.locations = locations;
    }

    public List<TripStep> getTripSteps() {
        return tripSteps;
    }

    public void setTripSteps(List<TripStep> tripSteps) {
        this.tripSteps = tripSteps;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(Date plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public Location getStartLocation() {
        return getLocations().get(0).getLocation();
    }

    public Location getEndLocation() {
        int lastLocationNumber = getLocations().size() - 1;
        return getLocations().get(lastLocationNumber).getLocation();
    }

}
