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
	public ResponseEntity<?> join(@RequestBody TestDto joinInfo) {
		String token = authService.join(joinInfo);

		if (token == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("회원가입 실패");

		return ResponseEntity.ok(token);
	}
}
