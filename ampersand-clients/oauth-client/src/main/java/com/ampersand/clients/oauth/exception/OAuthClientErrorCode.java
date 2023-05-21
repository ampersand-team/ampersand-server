package com.ampersand.clients.oauth.exception;

import com.ampersand.common.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OAuthClientErrorCode implements ErrorCode {
    CLIENT_NOT_FOUND("CLIENT_NOT_FOUND", "지원하지 않는 소셜 로그인 제공사입니다"),

    OAUTH_LOGIN_FAILED("OAUTH_LOGIN_FAILED", "소셜 로그인에 실패했습니다.");

    private final String code;

    private final String message;
}
