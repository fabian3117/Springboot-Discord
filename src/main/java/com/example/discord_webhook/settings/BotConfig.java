package com.example.discord_webhook.settings;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {
    private String token="MTMxNTEyNTkxNDY2MDUwNzY5OQ.Gqj7jc.NM1N1e-aVmaZwjlPK9ILmKZAYWzpvPIqoWaarQ";
    @Bean
    public GatewayDiscordClient gatewayDiscordClient() {
        return DiscordClientBuilder.create(token)
                .build()
                .login()
                .block();
    }
}
