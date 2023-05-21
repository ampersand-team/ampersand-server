package com.ampersand.clients.oauth.kakao;

import com.ampersand.clients.oauth.OAuthUser;
import com.ampersand.clients.oauth.common.ProviderClient;
import com.ampersand.clients.oauth.kakao.clients.KakaoLoginApiClient;
import com.ampersand.clients.oauth.kakao.clients.KakaoUserInfoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KakaoClient extends ProviderClient {
    @Value("${kakao.client-id}")
    private String clientId;

    @Value("${kakao.redirect-uri}")
    private String redirectUri;

    private final KakaoLoginApiClient kakaoLoginApiClient;

    private final KakaoUserInfoClient kakaoUserInfoClient;

    @Override
    public boolean match(String providerName) {
        return providerName.equalsIgnoreCase("kakao");
    }

    @Override
    public String accessToken(String code) {
        var tokenResponse =
                kakaoLoginApiClient.getToken("authorization_code", clientId, redirectUri, code);
        return tokenResponse.getAccessToken();
    }

    @Override
    public OAuthUser userInfo(String accessToken) {
        var userInfo = kakaoUserInfoClient.getUserInfo("Bearer " + accessToken);
        return new OAuthUser(userInfo.getEmail());
    }
}
