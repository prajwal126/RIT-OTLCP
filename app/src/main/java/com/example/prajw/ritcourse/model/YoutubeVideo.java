package com.example.prajw.ritcourse.model;

/**
 * Created by prajw on 3/20/2018.
 */

public class YoutubeVideo {
    String videoUrl;

    public YoutubeVideo() {

    }

    public YoutubeVideo(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

}
