package com.example.comment.controller;

import com.example.comment.dto.request.ChatGPTQueryRequest;
import com.example.comment.dto.request.ChatGptRequest;
import com.example.comment.dto.request.CommentRequest;
import com.example.comment.dto.response.ChatGptResponse;
import com.example.comment.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments/chat-gpt")
public class ChatGptController {
    private final ChatGptService chatGptService;
    @PostMapping
    public ChatGptResponse createComment(@RequestBody ChatGPTQueryRequest request) {
        return chatGptService.getResponse(request);
    }
}
