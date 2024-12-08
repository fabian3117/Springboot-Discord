package com.example.discord_webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmbebedDiscord {
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
//    @JsonProperty("color")
//    private String color;




}
