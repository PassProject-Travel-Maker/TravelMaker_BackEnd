package com.ssafy.backend.domain.schedule.controller;

import com.ssafy.backend.domain.schedule.dto.ScheduleDto.*;
import com.ssafy.backend.domain.schedule.service.ScheduleService;
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
    private final ScheduleService scheduleService;

    // 스케줄 추가
    @PostMapping("/{plan_id}/{day_id}")
    public ResponseEntity<?> addSchedule(
            @RequestHeader("Authorization") String tokenHeader,
            @PathVariable("plan_id") Long planId,    // planId
            @PathVariable("day_id") Long dayId,    // dayId
            @RequestBody AddScheduleRequestDto addScheduleRequestDto) {

        String memberId = jwtUtil.getIdFromToken(tokenHeader.substring(7));

        if (memberId == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("검증되지 않은 사용자입니다.");

        // addSchedule 서비스 로직 호출
        scheduleService.addSchedule(addScheduleRequestDto, planId, dayId, memberId);

        return ResponseEntity.ok("여행 계획 생성 성공");
    }
}
