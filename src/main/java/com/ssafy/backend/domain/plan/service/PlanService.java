package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.plan.dto.PlanDto.*;

import java.util.List;

public interface PlanService {
    void createPlan(String memberId, CreatePlanRequestDto createPlanRequestDto);

    List<myPlanDto> myPlanList(String id);
}
