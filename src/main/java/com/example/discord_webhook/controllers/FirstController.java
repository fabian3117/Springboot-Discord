package com.example.discord_webhook.controllers;

import com.example.discord_webhook.dto.EmbebedDiscord;
import com.example.discord_webhook.dto.MessageDiscord;
import com.example.discord_webhook.service.MessageDiscordService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@Slf4j
@ControllerAdvice
public class FirstController {

    @Autowired
    private  MessageDiscordService messageDiscordService;
    /*
    @PostMapping("/enviarDatos")
    public String enviarDatos(@RequestBody MessageDiscord mensaje) throws URISyntaxException {

        URI uri = new URI(url);
        WebClient client = WebClient.create();
        MessageDiscord prueba = new MessageDiscord();
        EmbebedDiscord submsj = new EmbebedDiscord();
        submsj.setDescription("PRUEBA");

        submsj.setTitle("SUB mensaje");
        prueba.setEmbeds(List.of(submsj));
        prueba.setContent("Fs");
        Mono<String> result = client.post()
                .uri(uri)
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(BodyInserters.fromValue(prueba))
                .retrieve()
                .bodyToMono(String.class);
        return "";
    }

     */
    @PostMapping("/repply")
    public void pseudoProxy(@RequestBody @NonNull MessageDiscord mensaje) throws URISyntaxException {

        messageDiscordService.sendMessage(mensaje);
    }

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<String> handleCustomException(URISyntaxException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocurrió un error: " + ex.getMessage());
    }

}
