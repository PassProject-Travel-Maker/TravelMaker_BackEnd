package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.plan.dto.ScheduleDto.*;

public interface ScheduleService {

    void addSchedule(AddScheduleRequestDto addScheduleRequestDto, Long planId, Long dayId, String memberId);
}
