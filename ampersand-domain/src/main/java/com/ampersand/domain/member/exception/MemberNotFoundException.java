package com.ampersand.domain.member.exception;

import com.ampersand.common.exception.NotFoundException;

public class MemberNotFoundException extends NotFoundException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}
