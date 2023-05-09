package com.ampersand.domain.member.exception;

import com.ampersand.common.exception.NotFoundException;
import com.ampersand.domain.DomainErrorCode;

public class MemberNotFoundException extends NotFoundException {
    public MemberNotFoundException(String message) {
        super(DomainErrorCode.MEMBER_NOT_FOUND, message);
    }
}
