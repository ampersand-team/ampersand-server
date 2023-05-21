package com.ampersand.clients.oauth;

import com.ampersand.clients.oauth.common.ProviderClient;
import com.ampersand.clients.oauth.exception.ClientNotFoundException;
import com.ampersand.clients.oauth.exception.OAuthLoginFailedException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuthLoginService {
    private final List<ProviderClient> clients;

    public OAuthUser login(String provider, String code) {
        try {
            var client = resourceServerClient(provider);
            return client.login(code);
        } catch (Exception e) {
            throw new OAuthLoginFailedException(e);
        }
    }

    private ProviderClient resourceServerClient(String providerName) {
        return clients.stream()
                .filter(it -> it.match(providerName))
                .findAny()
                .orElseThrow(() -> new ClientNotFoundException(providerName));
    }
}
