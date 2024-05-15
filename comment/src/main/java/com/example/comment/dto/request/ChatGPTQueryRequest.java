package com.example.comment.dto.request;

import com.example.comment.global.domain.dto.MessageDto;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatGPTQueryRequest {
    private String model;
    private List<MessageDto> messages;
    private int temperature;
    private int max_tokens;
}
