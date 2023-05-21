package com.ampersand.clients.oauth.kakao.clients;

import com.ampersand.clients.oauth.kakao.response.KakaoUserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "KakaoUserInfoClient", url = "https://kapi.kakao.com")
public interface KakaoUserInfoClient {
    @GetMapping("/v2/user/me")
    KakaoUserInfo getUserInfo(@RequestHeader(name = "Authorization") String accessToken);
}
