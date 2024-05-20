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
    public List<ChatGptResponseDto> makePrompt(ChatGptRequestDto chatGptRequestDto) {
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
//        System.out.println(prompt);

        PromptRequestDto promptRequestDto = new PromptRequestDto(model, prompt);
        PromptResponseDto promptResponseDto
                = template.postForObject(apiURL, promptRequestDto, PromptResponseDto.class);

        // 응답 가공
        String result = promptResponseDto.getChoices().get(0).getMessage().getContent();
        System.out.println(result);

        String[] paragraphs = result.split("일차");
        List<ChatGptResponseDto> chatGptResponseDtoList = new ArrayList<>();

        for (int i = 1; i < paragraphs.length; i++) {
            String[] lines = paragraphs[i].split("\n", 2);
            String title = lines[0].trim();
            String recommend = lines.length > 1 ? lines[1].trim() : "";
            recommend = recommend.replace("\n", "<br/>");   // TODO: 이건 프론트에서 하는 게 맞는 거 같기도?

            ChatGptResponseDto chatGptResponseDto = new ChatGptResponseDto(i, title, recommend);
            chatGptResponseDtoList.add(chatGptResponseDto);
        }

        return chatGptResponseDtoList;
    }
}
