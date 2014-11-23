package pl.edu.agh.domain.locations;

import pl.edu.agh.domain.common.implementation.BaseObject;
import pl.edu.agh.domain.useraccounts.UserAccount;

import java.util.Date;

/**
 * Created by Krzysiu on 2014-06-09.
 */
public class Comment extends BaseObject {

    public enum Rating {
        VERY_BAD("Very Bad"),
        BAD("Bad"),
        OK("Ok"),
        GOOD("Good"),
        EXCELLENT("Excellent"),;

        private String description;

        Rating(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private UserAccount userAccount;
    private Location location;
    private Rating rating;
    private String comment;
    private Date date;

    public Comment() {
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location) {
        this.location = location;
    }

    public Rating getRating() {
        return rating;
    }
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
