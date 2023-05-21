package com.ampersand.clients.oauth.kakao.clients;

import com.ampersand.clients.oauth.kakao.response.KakaoTokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "KakaoLoginApiClient", url = "https://kauth.kakao.com")
public interface KakaoLoginApiClient {
    @PostMapping("/oauth/token")
    KakaoTokenResponse getToken(
            @RequestParam("grant_type") String grantType,
            @RequestParam("client_id") String clientId,
            @RequestParam("redirect_uri") String redirectUri,
            @RequestParam("code") String code);
}
