package model;

import java.util.Date;

public class Reels extends Post{
    private int duration;
    private int playedCount;
    public Reels(String postId, ContentState status, Date timeUpload, ContentType postType, int duration, int playedCount) {
        super(postId, status, timeUpload, postType);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }
}
