package pl.edu.agh.domain.locations;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import pl.edu.agh.domain.common.implementation.UserVersionedBaseObject;

import java.util.List;

/**
 * Created by Krzysiu on 2014-05-25.
 */
@JsonIgnoreProperties(ignoreUnknown = true, value = {"lastModificationByAccount", "removedByAccount", "lastModificationDate", "removalDate"})
public class Location extends UserVersionedBaseObject {

    public enum Status {
        /**
         * Draft that user created, cannot be used as Location (FK), can be changed to available state.
         */
        DRAFT,
        /**
         * Currently available and send to user location that will be shown on the map.
         */
        AVAILABLE,
        /**
         * Currently unavaible but not removed from database location. Location is unavailable for some reason for some time.
         */
        UNAVAILABLE,
        /**
         * Permanently unavailable location.
         */
        REMOVED
    }

    private String name;
    private String description;
    private double latitude;
    private double longitude;
    private Status status;
    private boolean usersPrivate;
    private String url;
    private double rating;
    private Address address;
    private List<Comment> comments;

    public Location() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsersPrivate() {
        return usersPrivate;
    }

    public void setUsersPrivate(boolean usersPrivate) {
        this.usersPrivate = usersPrivate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
