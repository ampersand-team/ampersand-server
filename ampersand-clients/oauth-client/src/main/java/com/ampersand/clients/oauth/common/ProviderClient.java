package com.ampersand.clients.oauth.common;

import com.ampersand.clients.oauth.OAuthUser;

public abstract class ProviderClient implements Matchable {
    public OAuthUser login(String code) {
        String accessToken = accessToken(code);
        return userInfo(accessToken);
    }

    protected abstract String accessToken(String code);

    protected abstract OAuthUser userInfo(String accessToken);
}
