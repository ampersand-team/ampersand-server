package com.ampersand.clients.oauth.exception;

import com.ampersand.common.exception.AmpersandException;

public class ClientNotFoundException extends AmpersandException {
    public ClientNotFoundException(String message) {
        super(OAuthClientErrorCode.CLIENT_NOT_FOUND, "지원하지 않는 소셜 로그인 제공사입니다. 제공사명: " + message);
    }
}
