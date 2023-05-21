package com.ampersand.clients.oauth.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.ampersand.clients.oauth")
public class FeignConfig {}
