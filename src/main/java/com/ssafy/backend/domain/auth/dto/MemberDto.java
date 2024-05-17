package com.ssafy.backend.domain.auth.dto;

import com.ssafy.backend.domain.auth.model.Member;
import lombok.*;

public class MemberDto {
	
	@Data
	public static class TestDto {
		private String id;
		private String password;
		private String name;
	}

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @ToString
    public static class JoinRequestDto {
        private String id;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private String addr;

        public Member toEntity() {
            return Member.builder()
                    .id(this.getId())
                    .password(this.getPassword())
                    .name(this.getName())
                    .nickname(this.getNickname())
                    .email(this.getEmail())
                    .addr(this.getAddr())
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FindMemberByIdDto {
        private String id;
        private String password;
        private String name;
        private String nickname;
        private String email;
        private String addr;
    }
}
