package com.example.eventsproducer.controller;

import com.example.eventsproducer.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccessTokenController {

    private final AccessTokenService accessTokenService;

    @GetMapping("/spotify/fetch")
    public String fetchMyProfile(){
        log.info("fetching token");
        String accessToken = this.accessTokenService.getToken();
        log.info("Token fetched: " + accessToken);
        return accessToken;
    }
}
