package com.ampersand.clients.oauth.github.clients;

import com.ampersand.clients.oauth.github.response.GithubEmailResponse;
import com.ampersand.clients.oauth.github.response.GithubUserInfoResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "GithubUserInfoClient", url = "https://api.github.com")
public interface GithubUserInfoClient {
    @GetMapping("/user")
    GithubUserInfoResponse getUserInfo(@RequestHeader(name = "Authorization") String accessToken);

    @GetMapping(value = "/user/public_emails", produces = "application/vnd.github+json")
    List<GithubEmailResponse> getUserEmail(
            @RequestHeader(name = "Authorization") String accessToken);
}
