package com.ampersand.clients.oauth.github;

import com.ampersand.clients.oauth.OAuthUser;
import com.ampersand.clients.oauth.common.ProviderClient;
import com.ampersand.clients.oauth.github.clients.GithubAccessTokenClient;
import com.ampersand.clients.oauth.github.clients.GithubUserInfoClient;
import com.ampersand.clients.oauth.github.response.GithubEmailResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GithubClient extends ProviderClient {
    @Value("${github.client-id}")
    private String clientId;

    @Value("${github.client-secret}")
    private String clientSecret;

    private final GithubAccessTokenClient githubAccessTokenClient;

    private final GithubUserInfoClient githubUserInfoClient;

    @Override
    public boolean match(String providerName) {
        return providerName.equalsIgnoreCase("github");
    }

    @Override
    public String accessToken(String code) {
        var request =
                new GithubAccessTokenClient.GithubAccessTokenRequest(clientId, clientSecret, code);
        var tokenResponse = githubAccessTokenClient.getAccessToken(request);
        return tokenResponse.getAccessToken();
    }

    @Override
    public OAuthUser userInfo(String accessToken) {
        var userInfo = githubUserInfoClient.getUserInfo("token " + accessToken);
        if (userInfo.getEmail() == null) {
            var emailResponses = githubUserInfoClient.getUserEmail("Bearer " + accessToken);
            var email = extractEmail(emailResponses);
            return new OAuthUser(email);
        }
        return new OAuthUser(userInfo.getEmail());
    }

    private String extractEmail(List<GithubEmailResponse> emailResponses) {
        return emailResponses.stream()
                .map(GithubEmailResponse::getEmail)
                .filter(email -> !email.contains("@users.noreply.github.com"))
                .findFirst()
                .orElseThrow();
    }
}
