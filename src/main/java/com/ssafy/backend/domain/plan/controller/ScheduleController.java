package com.ssafy.backend.domain.plan.controller;

import com.ssafy.backend.domain.plan.dto.PlanDto;
import com.ssafy.backend.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day")
@RequiredArgsConstructor
public class ScheduleController {

    private final JWTUtil jwtUtil;

    // 스케줄 추가
    @PostMapping("/{plan_id}/{day_id}")
    public ResponseEntity<?> addSchedule(
            @RequestHeader("Authorization") String tokenHeader,
            @PathVariable("plan_id") Long planId,    // planId
            @PathVariable("day_id") Long dayId,    // dayId
            @RequestBody PlanDto.CreatePlanRequestDto createPlanRequestDto) {

        String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));

        if (memberId == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

        // createPlan 서비스 로직 호출
//        planService.createPlan(memberId, createPlanRequestDto);

        return ResponseEntity.ok("여행 계획 생성 성공");
    }
}
