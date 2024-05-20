package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.plan.dto.ChatGptDto.*;

import java.util.List;

public interface ChatGptService {
    List<ChatGptResponseDto> makePrompt(ChatGptRequestDto chatGptRequestDto);
}
