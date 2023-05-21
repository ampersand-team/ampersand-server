package com.ampersand.clients.oauth.github.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GithubEmailResponse {
    @JsonProperty("email")
    private String email;

    @JsonProperty("verified")
    private boolean verified;

    @JsonProperty("primary")
    private boolean primary;

    @JsonProperty("visibility")
    private String visibility;
}
