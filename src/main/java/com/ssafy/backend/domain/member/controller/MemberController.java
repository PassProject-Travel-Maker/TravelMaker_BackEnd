package com.ssafy.backend.domain.member.controller;

import com.ssafy.backend.domain.member.dto.MemberDto.*;
import com.ssafy.backend.domain.member.service.MemberService;
import com.ssafy.backend.domain.plan.dto.PlanDto.*;
import com.ssafy.backend.domain.plan.service.PlanService;
import com.ssafy.backend.util.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
	// TODO: (프론트에서) 마이페이지 들어가면 '내 정보 조회', '내 여행 계획 조회' 컨트롤러 onMounted
	private final JWTUtil jwtUtil;
	private final MemberService memberService;
	private final PlanService planService;
	
	// 내 정보 조회
	@GetMapping("/myInfo/{id}")
	public ResponseEntity<?> myInfo(
			@PathVariable("id") String id,
			@RequestHeader("Authorization") String tokenHeader) {

		String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
		System.out.println("memberId: " + memberId);

		if (!id.equals(memberId))
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

		// service에서 member 정보 조회
		MyInfoDto myInfoDto = memberService.myInfo(id);
		if(myInfoDto == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");

		return ResponseEntity.ok(myInfoDto);
	}
	
	
	// 내 여행 계획 조회
	@GetMapping("/myTravelList/{id}")
	public ResponseEntity<?> myTravel(
			@PathVariable("id") String id,
			@RequestHeader("Authorization") String tokenHeader) {

		String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));

		if (!id.equals(memberId))
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

		// service에서 member 정보 조회
		List<MyPlanDto> myPlanDtoList = planService.myPlanList(memberId);
		return ResponseEntity.ok(myPlanDtoList);
	}

}
