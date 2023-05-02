package com.ampersand.domain.member.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("회원 테스트")
class MemberTest {
    @Test
    void 회원을_생성한다() {
        assertDoesNotThrow(
                () -> new Member("email@email.com", "김철수", "https://ampersand.com/image.png"));
    }

    @Test
    void 회원_정보를_수정한다() {
        Member member = new Member("email@email.com", "김철수", "https://ampersand.com/image.png");

        member.update("김영희", "https://ampersand.com/image2.png");

        assertThat(member.getEmail()).isEqualTo("email@email.com");
        assertThat(member.getName()).isEqualTo("김영희");
        assertThat(member.getProfileImageUrl()).isEqualTo("https://ampersand.com/image2.png");
    }

    @Test
    void delete() {
        Member member = new Member("email@email.com", "김철수", "https://ampersand.com/image.png");

        member.delete();

        assertThat(member.isDeleted()).isTrue();
    }
}
