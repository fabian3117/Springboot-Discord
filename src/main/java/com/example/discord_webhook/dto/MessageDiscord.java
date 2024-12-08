package com.example.discord_webhook.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
//@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDiscord   {
    @Setter
    @JsonProperty("content")

    private String content;
//    private String attachments;

    @JsonProperty("embeds")
    private List<EmbebedDiscord> embeds=new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<EmbebedDiscord> getEmbeds() {
        return embeds;
    }

    public void setEmbeds(List<EmbebedDiscord> embeds) {
        this.embeds = embeds;
    }
}
