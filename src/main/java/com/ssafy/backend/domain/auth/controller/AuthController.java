package com.ssafy.backend.domain.auth.controller;

import com.ssafy.backend.domain.auth.dto.MemberDto.*;
import com.ssafy.backend.domain.auth.model.Member;
import com.ssafy.backend.domain.auth.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final AuthService authService;

	// 회원 가입
	@PostMapping("/join")
	public ResponseEntity<?> join(@RequestBody JoinRequestDto joinRequestDto) {
		String token = authService.join(joinRequestDto);

		if (token == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패");

		return ResponseEntity.ok(token);
	}

	// 로그인
	@PostMapping("/login")
//		@ResponseBody
	public ResponseEntity<?> login(@RequestBody LoginRequestDto loginInfo) {
		System.out.println(loginInfo.getId() + " " + loginInfo.getPassword());
		String token = authService.login(loginInfo);

		if (token == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 잘못되었습니다.");

		return ResponseEntity.ok(token);

//			TokenDto tokenDto = new TokenDto(token);
//			return ResponseEntity.ok(tokenDto);
	}
}
