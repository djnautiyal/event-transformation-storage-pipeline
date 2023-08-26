package com.example.eventsproducer.controller;

import com.example.eventsproducer.service.AccessTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccessTokenController {

    private final AccessTokenService accessTokenService;

    @ResponseBody
    @GetMapping("/spotify/fetch")
    public String fetchMyProfile(){
        log.info("fetching token");
        String accessToken = this.accessTokenService.getToken();
        log.info("Token fetched: " + accessToken);
        return accessToken;
    }
}
