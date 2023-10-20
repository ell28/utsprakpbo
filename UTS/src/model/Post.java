package model;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
public class Post {
    private String postId;
    private ContentState status;
    private Date timeUpload;
    private ContentType postType;

    public Post(String postId, ContentState status, Date timeUpload, ContentType postType) {
        this.postId = postId;
        this.status = status;
        this.timeUpload = timeUpload;
        this.postType = postType;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public Date getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Date timeUpload) {
        this.timeUpload = timeUpload;
    }

    public ContentType getContentType() {
        return postType;
    }

    public void setPostType(ContentType postType) {
        this.postType = postType;
    }
}
