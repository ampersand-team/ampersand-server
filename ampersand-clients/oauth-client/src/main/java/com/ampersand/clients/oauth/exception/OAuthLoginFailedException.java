package com.ampersand.clients.oauth.exception;

import com.ampersand.common.exception.AmpersandException;

public class OAuthLoginFailedException extends AmpersandException {
    public OAuthLoginFailedException(Throwable e) {
        super(e, OAuthClientErrorCode.OAUTH_LOGIN_FAILED);
    }
}
