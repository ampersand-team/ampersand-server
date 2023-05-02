package com.ampersand.domain.member.exception;

import com.ampersand.common.exception.ErrorCode;

public enum MemberErrorCode implements ErrorCode {
    NOT_FOUND("MEMBER_NOT_FOUND", "회원을 찾을 수 없습니다.");

    private final String code;

    private final String message;

    MemberErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
