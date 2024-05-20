package com.ssafy.backend.domain.map.service;

import com.ssafy.backend.domain.map.dto.ChatGptDto.*;

import java.util.List;

public interface ChatGptService {
    String makePrompt(ChatGptRequestDto chatGptRequestDto);
}
