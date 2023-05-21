package com.ampersand.clients.oauth.google.clients;

import com.ampersand.clients.oauth.google.response.GoogleUserInfoResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GoogleUserInfoClient", url = "https://www.googleapis.com")
public interface GoogleUserInfoClient {
    @GetMapping("/oauth2/v3/userinfo")
    @Headers("Authorization: Bearer {accessToken}")
    GoogleUserInfoResponse getUserInfo(@RequestParam("access_token") String accessToken);
}
