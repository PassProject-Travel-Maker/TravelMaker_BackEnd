package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.plan.dto.PlanDto.*;

public interface PlanService {
    void createPlan(String memberId, CreatePlanRequestDto createPlanRequestDto);
}
