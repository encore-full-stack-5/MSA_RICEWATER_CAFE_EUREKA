package com.example.comment.global.domain.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatGptMessage {
    private String content;
    @JsonCreator
    public ChatGptMessage(@JsonProperty("content") String content) {
        this.content = content;
    }
}
