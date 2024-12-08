package com.example.discord_webhook.service;

import com.example.discord_webhook.dto.MessageDiscord;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class MessageDiscordService {
    @Value("${server.discord.webhook.url}")
    private String url ;
    private  URI uri;
    private final WebClient client = WebClient.builder().build();

    public static class DiscordSendMessageException extends RuntimeException {
        public DiscordSendMessageException(String message) {
            super(message);
        }
    }


    /**
     * This method is only to repeat one message to discord using the webhook
     * In application.properties has the url of webhook
     *
     * @param message
     */
    public void sendMessage(@NonNull MessageDiscord message) throws URISyntaxException {
//        WebClient client = WebClient.create();

        client.post()
                .uri(uri)
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(BodyInserters.fromValue(message))
                .retrieve()
                .bodyToMono(String.class)
                .subscribe();
    }

}
