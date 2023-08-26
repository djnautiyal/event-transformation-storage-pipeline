package com.example.eventsproducer.service;

import com.example.eventsproducer.dto.ArtistDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArtistDetailsService {
    private final String URL = "https://api.spotify.com/v1/artists/";

    private final RestTemplate restTemplate;
    private ArtistDto artistDto;

    // TODO definitely not void
    //TODO Notnull constraint
    public void getArtist(String token,String artistId){
        String apiUrl = URL + artistId;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        log.info("headers is set as: " + headers.toString());
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<ArtistDto> response = restTemplate.exchange(apiUrl, HttpMethod.GET, request,  ArtistDto.class);
        log.info("Artist DTO fetch: " + response.getBody());
    }

}
