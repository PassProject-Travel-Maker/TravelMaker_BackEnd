package com.ssafy.backend.domain.map.service;

import com.ssafy.backend.domain.map.dto.ChatGptDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// TODO: model, apiURL 자동 빈 생성
@Service
@RequiredArgsConstructor
public class ChatGptServiceImpl implements ChatGptService{

    private final RestTemplate template;

//    @Value("${openai.model}")
//    private String model;
    private String model = "gpt-4-turbo";

//    @Value("${openai.api.url}")
//    private String apiURL;
    private String apiURL = "https://api.openai.com/v1/chat/completions";

    @Override
    public String makePrompt(ChatGptRequestDto chatGptRequestDto) {
        // 요청 가공
        StringBuilder sb = new StringBuilder();
        sb.append("여행 경로 추천해줘.")
                .append("\n지역: ").append(chatGptRequestDto.getLocation())
                .append("\n여행 기간: ").append(chatGptRequestDto.getPeriod())
                .append("\n인원: ").append(chatGptRequestDto.getPeopleNum())
                .append("\n예상 경비: ").append(chatGptRequestDto.getCost())
                .append("\n추가 참고 사항: ").append(chatGptRequestDto.getEtc())
                .append("\n각 날짜는 '1일차 : 제목' 이런 식으로, 각 장소에는 [[와 ]]로 감싸서 알려줘.");
        String prompt = sb.toString();

        PromptRequestDto promptRequestDto = new PromptRequestDto(model, prompt);
        PromptResponseDto promptResponseDto
                = template.postForObject(apiURL, promptRequestDto, PromptResponseDto.class);

        // 응답 가공
        String result = promptResponseDto.getChoices().get(0).getMessage().getContent();
        System.out.println(result);

        return result;
    }
}
