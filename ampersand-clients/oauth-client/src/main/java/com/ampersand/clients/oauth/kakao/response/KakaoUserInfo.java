package com.ampersand.clients.oauth.kakao.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KakaoUserInfo {
    @JsonProperty("id")
    private String id;

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount;

    public String getEmail() {
        return this.kakaoAccount.getEmail();
    }

    static class KakaoAccount {
        @JsonProperty("email")
        private String email;

        public String getEmail() {
            return email;
        }
    }
}
