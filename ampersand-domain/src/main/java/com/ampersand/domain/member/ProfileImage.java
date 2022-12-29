package com.ampersand.domain.member;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileImage {
    private String imageName;

    private String imageUrl;

    public ProfileImage(String imageName, String imageUrl) {
        this.imageName = imageName;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProfileImage image = (ProfileImage) o;
        return Objects.equals(getImageName(), image.getImageName())
                && Objects.equals(getImageUrl(), image.getImageUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getImageName(), getImageUrl());
    }
}
