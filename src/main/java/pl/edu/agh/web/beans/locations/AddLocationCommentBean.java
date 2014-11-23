package pl.edu.agh.web.beans.locations;

import pl.edu.agh.domain.locations.Comment;
import pl.edu.agh.domain.locations.Location;
import pl.edu.agh.tools.StringTools;
import pl.edu.agh.web.beans.common.BaseBean;
import pl.edu.agh.web.messages.FormValidationErrorMessages;
import pl.edu.agh.web.messages.InfoMessages;
import pl.edu.agh.web.navigation.NavigationResults;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Krzysztof Kicinger on 2014-11-22.
 */
@ManagedBean(name = "addLocationCommentBean")
@RequestScoped
public class AddLocationCommentBean extends BaseBean {

    private Location location;
    private Comment.Rating selectedRating;
    private String comment;

    public Location getLocation() {
        try {
            location = getSessionBean().getDataCacheService().getSelectedLocation(getSessionBean().getSelectedLocationId(), getSessionBean().getUserToken());
        } catch (Exception ex) {
            processRequestException(ex);
        }
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Comment.Rating getSelectedRating() {
        return selectedRating;
    }

    public void setSelectedRating(Comment.Rating selectedRating) {
        this.selectedRating = selectedRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Comment.Rating[] getRatingValues() {
        return Comment.Rating.values();
    }

    public String addCommentAction() {
        refreshPageData();
        if(StringTools.isNullOrEmpty(getComment())) {
            addErrorMessage(FormValidationErrorMessages.COMMENT_IS_REQUIRED);
        }
        if(!isErrorMessageEmpty()) {
            return NavigationResults.RELOAD_PAGE.getNavigation();
        }

        try {
            getSessionBean().getLocationsManagementService().addLocationComment(getLocation().getId(), getSelectedRating(), getComment(), getSessionBean().getUserToken());
            refreshPageData();
            addInfoMessage(InfoMessages.COMMENT_SUCCESSFULLY_ADDED);
        } catch(Exception ex) {
            processRequestException(ex);
        }
        return tryToNavigate(NavigationResults.SHOW_LOCATION_DESCRIPTION_PAGE);
    }
}
