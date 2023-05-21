package com.ampersand.clients.oauth.github.clients;

import com.ampersand.clients.oauth.github.response.GithubAccessTokenResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "GithubAccessTokenClient", url = "https://github.com")
public interface GithubAccessTokenClient {
    @PostMapping(value = "/login/oauth/access_token", produces = "application/json")
    GithubAccessTokenResponse getAccessToken(@RequestBody GithubAccessTokenRequest request);

    @AllArgsConstructor
    class GithubAccessTokenRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_secret")
        private String clientSecret;

        @JsonProperty("code")
        private String code;
    }
}
