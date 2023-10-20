package model;
import java.util.*;

public class Story extends  Post{
    private int duration;
    private int views;
    public Story(String postId, ContentState status, Date timeUpload, ContentType postType, int duration, int views) {
        super(postId, status, timeUpload, postType);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
