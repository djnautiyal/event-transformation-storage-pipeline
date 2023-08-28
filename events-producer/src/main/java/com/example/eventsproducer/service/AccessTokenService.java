package com.example.eventsproducer.service;

import com.example.eventsproducer.dto.AccessTokenDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccessTokenService {

    private final String URL = "https://accounts.spotify.com/api/token";
    private final RestTemplate restTemplate;

    @Value("${com.spotify.client-id}")
    private String clientID;

    @Value("${com.spotify.client-secret}")
    private String clientSecret;

    public String getToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        log.info("Content Type set as Application Form URLENCODED");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id", clientID);
        map.add("grant_type", "client_credentials");
        map.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<AccessTokenDto> response = restTemplate.postForEntity(URL, request, AccessTokenDto.class);
        return response.getBody().getAccess_token();
    }

}
