package xyz.moonsod.youtubevideosearch.obj.model.video;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoRoot {
    public String kind;
    public String etag;
    public String nextPageToken;
    public String regionCode;
    public PageInfo pageInfo;
    public List<Item> items;
}

