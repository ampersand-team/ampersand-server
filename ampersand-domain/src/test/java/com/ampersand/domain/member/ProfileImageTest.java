package com.ampersand.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("프로필 이미지 단위테스트")
class ProfileImageTest {
    @Test
    void 프로필_이미지를_생성한다() {
        assertDoesNotThrow(() -> new ProfileImage("프로필이미지.png", "https://ampersand-cdn.com"));
    }

    @Test
    void 이름과_URL이_같은_프로필_이미지는_동등하다() {
        assertThat(new ProfileImage("프로필이미지.png", "https://ampersand-cdn.com"))
                .isEqualTo(new ProfileImage("프로필이미지.png", "https://ampersand-cdn.com"));
    }

    @Test
    void 이름과_URL이_같은_프로필_이미지는_hashCode가_같다() {
        assertThat(new ProfileImage("프로필이미지.png", "https://ampersand-cdn.com"))
                .hasSameHashCodeAs(new ProfileImage("프로필이미지.png", "https://ampersand-cdn.com"));
    }
}
