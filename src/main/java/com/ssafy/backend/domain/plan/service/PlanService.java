package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.plan.dto.PlanDto.*;

import java.util.List;

public interface PlanService {
    void createPlan(String memberId, CreatePlanRequestDto createPlanRequestDto);

    List<MyPlanDto> myPlanList(String memberId);

    PlanDetailResponseDto planDetail(Long id);

    String deletePlan(Long id);

    void modifyPlan(String memberId, Long planId, CreatePlanRequestDto createPlanRequestDto);
}
