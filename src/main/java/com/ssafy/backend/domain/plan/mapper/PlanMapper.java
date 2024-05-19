package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.dto.PlanDto.*;
import com.ssafy.backend.domain.plan.model.Plan;

import java.util.List;

public interface PlanMapper {

    void insertPlan(Plan plan);

    List<MyPlanDto> getMyPlan(String memberId);


    PlanDetailDto findById(Long id);
}
