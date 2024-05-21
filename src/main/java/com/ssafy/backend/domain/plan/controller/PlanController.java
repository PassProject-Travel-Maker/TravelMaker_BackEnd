package com.ssafy.backend.domain.plan.controller;

import com.ssafy.backend.domain.plan.dto.PlanDto.*;
import com.ssafy.backend.domain.plan.model.Plan;
import com.ssafy.backend.domain.plan.service.PlanService;
import com.ssafy.backend.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {

    private final JWTUtil jwtUtil;
    private final PlanService planService;

    // 여행 계획 생성
    @PostMapping
    public ResponseEntity<?> createPlan(
            @RequestHeader("Authorization") String tokenHeader,
            @RequestBody CreatePlanRequestDto createPlanRequestDto) {

        String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));

        if (memberId == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

        // createPlan 서비스 로직 호출
        planService.createPlan(memberId, createPlanRequestDto);

        return ResponseEntity.ok("여행 계획 생성 성공");
    }

    // 특정 여행 계획 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> planDetail(
            @PathVariable("id") Long id,    // planId
            @RequestHeader("Authorization") String tokenHeader) {

        String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
        if (memberId == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

        // PlanDetailResponseDto
        PlanDetailResponseDto planDetailResponseDto = planService.planDetail(id);

        if(planDetailResponseDto == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("찾을 수 없는 정보입니다.");

        return ResponseEntity.ok(planDetailResponseDto);
    }

    // 특정 여행 계획 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlan(
            @PathVariable("id") Long id,
            @RequestHeader("Authorization") String tokenHeader) {

        String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
        if (memberId == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("삭제할 권한이 없습니다.");

        String message = planService.deletePlan(id);

        return ResponseEntity.ok(message);
    }

    // 특정 여행 계획 수정
    @PostMapping("/{id}")
    public ResponseEntity<?> modifyPlan(
            @PathVariable("id") Long id,
            @RequestHeader("Authorization") String tokenHeader,
            @RequestBody CreatePlanRequestDto createPlanRequestDto) {

        String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));
        if (memberId == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

        // 여행 계획 수정
        planService.modifyPlan(memberId, id, createPlanRequestDto);

        return ResponseEntity.ok("여행 계획 수정 성공");
    }
}
