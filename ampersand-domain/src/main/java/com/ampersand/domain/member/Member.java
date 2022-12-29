package com.ampersand.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nickname;

    @Embedded
    private ProfileImage image;

    public Member(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public void update(String nickname) {
        this.nickname = nickname;
    }

    public void registerImage(ProfileImage image) {
        this.image = image;
    }
}
