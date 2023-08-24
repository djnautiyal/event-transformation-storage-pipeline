package com.example.eventsproducer.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="com.spotify.client")
public class SpotifyAppConfigurationProperties {

        private String clientId;
        private String clientSecret;
}
