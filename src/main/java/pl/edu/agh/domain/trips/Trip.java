package pl.edu.agh.domain.trips;


import pl.edu.agh.domain.common.implementation.VersionedBaseObject;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.domain.useraccounts.UserAccount;

import java.util.Date;
import java.util.List;

/**
 * Created by Krzysiu on 2014-09-14.
 */
public class Trip extends VersionedBaseObject {

    private String name;
    private String description;
    private UserAccount author;

    //private List<UserAccount> participants; //TODO: rethink of this functionality

    private List<TripDay> days;
    private Date startDate;
    private Date endDate;

    public Trip() {
    }

    public Trip(String name, String description, UserAccount author, Date startDate, Date endDate) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserAccount getAuthor() {
        return author;
    }

    public void setAuthor(UserAccount author) {
        this.author = author;
    }

    public List<TripDay> getDays() {
        return days;
    }

    public void setDays(List<TripDay> days) {
        this.days = days;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Location getStartLocation() {
        return getDays().get(0).getLocations().get(0).getLocation();
    }

    public Location getEndLocation() {
        TripDay tripDay = getDays().get(getDays().size() - 1);
        int lastLocationNumber = tripDay.getLocations().size() - 1;
        return tripDay.getLocations().get(lastLocationNumber).getLocation();
    }

}
