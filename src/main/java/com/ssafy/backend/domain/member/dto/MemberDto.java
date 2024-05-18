package com.ssafy.backend.domain.member.dto;

import com.ssafy.backend.domain.member.model.Member;
import lombok.*;

public class MemberDto {

    public static class TestReqDto {

    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class TestRespDto {
        private String id;
        private String name;
        private String nickname;
        private String email;
        private String addr;

        public Member toEntity() {
            return Member.builder()
                    .id(this.getId())
                    .name(this.getName())
                    .nickname(this.getNickname())
                    .email(this.getEmail())
                    .addr(this.getAddr())
                    .build();
        }
    }
}
