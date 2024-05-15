package com.example.comment.global.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatGptChoice {
    private ChatGptMessage message;
    @JsonCreator
    public ChatGptChoice(@JsonProperty("message") ChatGptMessage message) {
        this.message = message;
    }
}
