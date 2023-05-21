package com.ampersand.clients.oauth.google.clients;

import com.ampersand.clients.oauth.google.response.GoogleAccessTokenResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "GoogleAccessTokenClient", url = "https://oauth2.googleapis.com")
public interface GoogleAccessTokenClient {
    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    GoogleAccessTokenResponse getAccessToken(@RequestBody GoogleAccessTokenRequest params);

    @AllArgsConstructor
    class GoogleAccessTokenRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_secret")
        private String clientSecret;

        @JsonProperty("code")
        private String code;

        @JsonProperty("grant_type")
        private String grantType;

        @JsonProperty("redirect_uri")
        private String redirectUri;
    }
}
