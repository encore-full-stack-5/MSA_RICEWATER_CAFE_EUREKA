package com.example.comment.service;

import com.example.comment.api.ChatGptClient;
import com.example.comment.dto.request.ChatGPTQueryRequest;
import com.example.comment.dto.response.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChatGptService {
    private final ChatGptClient chatGptClient;
    @Value("${openai.key}")
    private String key;
    public ChatGptResponse getResponse(String question) {
        ChatGPTQueryRequest request = new ChatGPTQueryRequest(question);
        // Feign 클라이언트를 통해 API 호출
        return chatGptClient.sendMessage(key, request);
    }
}
