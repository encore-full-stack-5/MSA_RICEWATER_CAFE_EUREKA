package com.example.comment.dto.response;

import com.example.comment.global.domain.dto.ChatGptChoice;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ChatGptResponse {
    private String content;


    @JsonCreator
    public ChatGptResponse(@JsonProperty("choices") ChatGptChoice[] choices) {
        if (choices != null && choices.length > 0) {
            this.content = choices[0].getMessage().getContent();
        }
    }
}
