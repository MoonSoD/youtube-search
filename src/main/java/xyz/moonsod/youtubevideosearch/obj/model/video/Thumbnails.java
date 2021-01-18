package xyz.moonsod.youtubevideosearch.obj.model.video;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thumbnails {

    //Had to use annnotation, because default is a keyword, thanks youtube :)
    @JsonProperty("default")
    public Default def;

    public Medium medium;
    public High high;
}