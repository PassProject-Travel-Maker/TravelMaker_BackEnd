package com.ssafy.backend.domain.auth.controller;

import com.ssafy.backend.domain.auth.dto.AuthDto.*;
import com.ssafy.backend.domain.auth.service.AuthService;

import com.ssafy.backend.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final JWTUtil jwtUtil;
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
	public ResponseEntity<?> login(@RequestBody LoginRequestDto loginInfo) {
		System.out.println(loginInfo.getId());
		String token = authService.login(loginInfo);

		if (token == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("아이디 또는 비밀번호가 잘못되었습니다.");

		return ResponseEntity.ok(token);
	}

	// 회원 정보 수정
	@PatchMapping("/modify")
	public ResponseEntity<?> modify(
			@RequestHeader("Authorization") String tokenHeader,
			@RequestBody String password) {

		String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
		if (memberId == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 사용자입니다.");

		return null;
	}

	// 회원 탈퇴
	// TODO: RequestBody DTO로 변경
	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(
			@RequestHeader("Authorization") String tokenHeader,
			@RequestBody String password) {

		String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
		if (memberId == null)
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("유효하지 않은 사용자입니다.");

		String message = authService.deleteMember(memberId, password);
		return ResponseEntity.ok(message);
	}
}
