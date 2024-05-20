package com.ssafy.backend.domain.map.controller;

import com.ssafy.backend.domain.map.dto.ChatGptDto.*;
import com.ssafy.backend.domain.map.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatGptController {

    private final ChatGptService chatGptService;

    // TODO: ChatGptResponseDto에 맞게 가공
    /*
            TODO: 프론트에서 recommend 값에 있는 장소들을 버튼 태그로 바꾸기 (아래처럼!)
            **[ => <button class="">
            ]** => </button>
    */
    @GetMapping("/recommend")
    public ResponseEntity<?> recommend(@RequestBody ChatGptRequestDto chatGptRequestDto) {
        List<ChatGptResponseDto> chatGptResponseDto = chatGptService.makePrompt(chatGptRequestDto);
        return ResponseEntity.ok(chatGptResponseDto);
    }
}
