package com.example.comment.service;

import com.example.comment.api.ChatGptClient;
import com.example.comment.dto.request.ChatGPTQueryRequest;
import com.example.comment.dto.response.ChatGptResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChatGptService {
    private final ChatGptClient chatGptClient;
    public ChatGptResponse getResponse(ChatGPTQueryRequest question) {
        ChatGPTQueryRequest request = new ChatGPTQueryRequest(
                question.getModel(),
                question.getMessages(),
                question.getTemperature(),
                question.getMax_tokens());
        // Feign 클라이언트를 통해 API 호출
        return chatGptClient.sendMessage("토큰", request);
    }
}
