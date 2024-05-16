package com.example.comment.dto.request;

import com.example.comment.global.domain.dto.MessageDto;

import java.util.List;

public record ChatGPTQueryRequest(String model, List<MessageDto> messages, double temperature,int max_tokens){
    public ChatGPTQueryRequest(String question) {
        this("gpt-3.5-turbo", List.of(new MessageDto("user", "이 댓글이 부정적이면 false를 반환해주고 긍정적이면 true를 반환해줘"+question)), 0.5, 100);
    }
}
