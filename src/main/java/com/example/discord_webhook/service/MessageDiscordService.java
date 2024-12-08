package com.example.discord_webhook.service;

import com.example.discord_webhook.dto.MessageDiscord;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Service
public class MessageDiscordService {
    @Value("${server.discord.webhook.url}")
    private static final String url="https://discord.com/api/webhooks/1315002879190368268/6l1o-g0He-hEQ92nLlrZt2lzScUVw8lorNxiYeP9KB7xXpZGenbOo7mKyGaVlJs39JcQ";

    private static final URI uri;
    private final WebClient client = WebClient.builder().build();



    static {
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
//            log.error("Error creating URI for Discord webhook: {}", e.getMessage());
            throw new RuntimeException(e);  // Re-throw as unchecked exception
        }
    }

    public static class DiscordSendMessageException extends RuntimeException {
        public DiscordSendMessageException(String message) {
            super(message);
        }
    }


    /**
     * This method is only to repeat one message to discord using the webhook
     * In application.properties has the url of webhook
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
                .subscribe()
                ;
        return;
    }

}
