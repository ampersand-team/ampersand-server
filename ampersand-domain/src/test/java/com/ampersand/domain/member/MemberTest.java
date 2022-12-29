package com.ampersand.domain.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("회원 단위테스트")
class MemberTest {
    @Test
    void 회원을_생성한다() {
        assertDoesNotThrow(() -> new Member("example@email.com", "ampersand"));
    }

    @Test
    void 회원의_닉네임을_변경한다() {
        Member member = new Member("example@email.com", "ampersand");

        member.update("ampersand2");

        assertThat(member.getNickname()).isEqualTo("ampersand2");
    }

    @Test
    void 프로필_이미지를_등록한다() {
        Member member = new Member("example@email.com", "ampersand");
        ProfileImage image = new ProfileImage("프로필이미지.png", "https://ampersand-cdn.com");

        member.registerImage(image);

        assertThat(member.getImage()).isEqualTo(image);
    }
}
