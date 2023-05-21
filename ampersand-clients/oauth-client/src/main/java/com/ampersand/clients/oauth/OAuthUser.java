package com.ampersand.clients.oauth;

public class OAuthUser {
    private final String email;

    public OAuthUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
