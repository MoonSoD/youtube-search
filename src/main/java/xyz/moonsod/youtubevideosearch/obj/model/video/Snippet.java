package xyz.moonsod.youtubevideosearch.obj.model.video;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Snippet {
    public Date publishedAt;
    public String channelId;
    public String title;
    public String description;
    public Thumbnails thumbnails;
    public String channelTitle;
    public String liveBroadcastContent;
    public Date publishTime;
}