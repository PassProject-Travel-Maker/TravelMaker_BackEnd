package com.ssafy.backend.domain.map.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ChatGptDto {


    // 사용자가 입력해서 받은 정보
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatGptRequestDto {
        String location;    // 여행 지역
        String period;      // 여행 기간
        String peopleNum;   // 인원
        String cost;        // 에상 경비
        String etc;         // 추가 참고 사항
    }

//    @Getter
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Message {
        private String role;
        private String content;
    }

//    @Getter
//    @NoArgsConstructor
//    @AllArgsConstructor
    @Data
    public static class PromptRequestDto {
        private String model;
        private List<Message> messages;

        public PromptRequestDto(String model, String prompt) {
            this.model = model;
            this.messages = new ArrayList<>();
            this.messages.add(new Message("user", prompt));
        }
    }

//    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @ToString
    public static class PromptResponseDto {
        private List<Choice> choices;
    }

//    @Getter
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Choice {
        private int index;
        private Message message;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChatGptResponseDto {
        private int num;    // 1일차, 2일차, ...
        private String title;   // 제주시 동부 지역 탐방
        private String recommend;
    }
}
