package com.ampersand.clients.oauth.google;

import com.ampersand.clients.oauth.OAuthUser;
import com.ampersand.clients.oauth.common.ProviderClient;
import com.ampersand.clients.oauth.google.clients.GoogleAccessTokenClient;
import com.ampersand.clients.oauth.google.clients.GoogleUserInfoClient;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GoogleClient extends ProviderClient {
    @Value("${google.client-id}")
    private String clientId;

    @Value("${google.client-secret}")
    private String clientSecret;

    @Value("${google.redirect-uri}")
    private String redirectUri;

    private final GoogleAccessTokenClient accessTokenClient;

    private final GoogleUserInfoClient userInfoClient;

    @Override
    public boolean match(String providerName) {
        return providerName.equalsIgnoreCase("google");
    }

    @Override
    public String accessToken(String code) {
        var request =
                new GoogleAccessTokenClient.GoogleAccessTokenRequest(
                        clientId,
                        clientSecret,
                        URLDecoder.decode(code, StandardCharsets.UTF_8),
                        "authorization_code",
                        redirectUri);

        var tokenResponse = accessTokenClient.getAccessToken(request);
        return tokenResponse.getAccessToken();
    }

    @Override
    public OAuthUser userInfo(String accessToken) {
        var userInfo = userInfoClient.getUserInfo(accessToken);
        return new OAuthUser(userInfo.getEmail());
    }
}
