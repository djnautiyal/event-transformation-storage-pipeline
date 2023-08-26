package com.example.eventsproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDto {
    private String id;
    private String name;
    private Followers followers;
    private int popularity;
    private List<String> genres;
    private List<Image> images;
    private ExternalUrls external_urls;

    @Data
    public static class Followers {
        private int total;
    }

    @Data
    public static class Image {
        private String url;
        private int width;
        private int height;
    }

    @Data
    public static class ExternalUrls {
        private String spotify;
    }
}


