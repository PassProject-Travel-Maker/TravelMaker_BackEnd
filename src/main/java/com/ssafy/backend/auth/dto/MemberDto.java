package com.ssafy.backend.auth.dto;

import lombok.Getter;

@Getter
public class MemberDto {
	
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String email;
	private String addr;

}
