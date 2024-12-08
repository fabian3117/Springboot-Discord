package com.example.discord_webhook.controllers;

import com.example.discord_webhook.dto.EmbebedDiscord;
import com.example.discord_webhook.dto.MessageDiscord;
import com.example.discord_webhook.service.MessageDiscordService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.util.List;

@RestController
//@RequiredArgsConstructor
//@AllArgsConstructor
@Slf4j
@ControllerAdvice
public class FirstController {

    @Autowired
    private RestTemplate restTemplate;
   @Autowired
    private final MessageDiscordService messageDiscordService;

    public FirstController(MessageDiscordService messageDiscordService) {
        this.messageDiscordService = messageDiscordService;
    }

    private final static String url="https://discord.com/api/webhooks/1315002879190368268/6l1o-g0He-hEQ92nLlrZt2lzScUVw8lorNxiYeP9KB7xXpZGenbOo7mKyGaVlJs39JcQ";

    @PostMapping("/enviarDatos")
    public String enviarDatos(@RequestBody MessageDiscord mensaje) throws URISyntaxException {

        URI uri = new URI(url);
        WebClient client = WebClient.create();
        MessageDiscord prueba=new MessageDiscord();
        EmbebedDiscord submsj=new EmbebedDiscord();
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
