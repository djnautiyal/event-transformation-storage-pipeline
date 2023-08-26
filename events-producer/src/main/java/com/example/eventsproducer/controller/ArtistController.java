package com.example.eventsproducer.controller;

import com.example.eventsproducer.constant.ApiPath;
import com.example.eventsproducer.service.AccessTokenService;
import com.example.eventsproducer.service.ArtistDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ArtistController {
    // TODO remove this constant
    private final String artistId = "1Xyo4u8uXC1ZmMpatF05PJ?si=pqgFDCcfTgunFFHqJ63OLQ";


    private RestTemplate restTemplate;
    private final AccessTokenService accessTokenService;
    private final ArtistDetailsService artistDetailsService;

    @GetMapping(value = ApiPath.GET_ARTIST)
    public String fetchArtistDetails(){
        log.info("Calling Spotify API for the artist: " + artistId);
        String token = accessTokenService.getToken();
        artistDetailsService.getArtist(token, artistId);
        return "Data fetched";
    }
}
