package com.ssafy.backend.domain.member.controller;

import com.ssafy.backend.util.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.backend.domain.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	// TODO: (프론트에서) 마이페이지 들어가면 '내 정보 조회', '내 여행 계획 조회' 컨트롤러 onMounted
	private final JWTUtil jwtUtil;
	
	// 내 정보 조회
	@PostMapping("/myInfo")
	public ResponseEntity<?> myInfo(
			@RequestHeader("Authorization") String tokenHeader) {

		System.out.println(tokenHeader);
		// 앞에 Bearer 을 잘라서 보냄 (띄어쓰기 포함)
		String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
		System.out.println("memberId: " + memberId);

		return null;
	}
	
	// 내 여행 계획 조회
	@GetMapping("/myPlan")
	public ResponseEntity<?> myPlan() {
		return null;
	}
}
