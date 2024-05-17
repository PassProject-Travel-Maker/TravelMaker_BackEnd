package com.ssafy.backend.domain.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.backend.domain.auth.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	// TODO: (프론트에서) 마이페이지 들어가면 '내 정보 조회', '내 여행 계획 조회' 컨트롤러 onMounted
	
	// 내 정보 조회
	@GetMapping("/myInfo")
	public ResponseEntity<?> myInfo() {
		return null;
	}
	
	// 내 여행 계획 조회
	@GetMapping("/myPlan")
	public ResponseEntity<?> myPlan() {
		return null;
	}
}
