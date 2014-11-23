package pl.edu.agh.services.serializers.locations;


import pl.edu.agh.domain.locations.Comment;

/**
 * Created by Krzysztof Kicinger on 2014-11-21.
 */
public class CommentRequestSerializer {

    private Comment.Rating rating;
    private String comment;

    public CommentRequestSerializer() {
    }

    public CommentRequestSerializer(Comment.Rating rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    public Comment.Rating getRating() {
        return rating;
    }

    public void setRating(Comment.Rating rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
