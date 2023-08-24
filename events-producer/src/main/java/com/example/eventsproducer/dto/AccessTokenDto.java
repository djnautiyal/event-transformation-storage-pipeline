package com.example.eventsproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDto {
    private String access_token;
    private String token_type;
    private String expires_in;
}
