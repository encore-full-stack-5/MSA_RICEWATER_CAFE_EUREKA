package com.example.comment.api;

import com.example.comment.dto.request.ChatGPTQueryRequest;
import com.example.comment.dto.response.ChatGptResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "chatGptClient", url = "https://api.openai.com/v1/chat")
public interface ChatGptClient {
    @PostMapping("/completions")
    ChatGptResponse sendMessage(@RequestHeader("Authorization") String authToken, @RequestBody ChatGPTQueryRequest request);
}
