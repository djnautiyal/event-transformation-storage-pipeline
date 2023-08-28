package com.example.eventsproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// TODO DTO pattern
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDto {
    private String access_token;
    private String token_type;
    private String expires_in;
}
