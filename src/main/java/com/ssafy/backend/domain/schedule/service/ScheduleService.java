package com.ssafy.backend.domain.schedule.service;

import com.ssafy.backend.domain.schedule.dto.ScheduleDto.*;

public interface ScheduleService {

    void addSchedule(AddScheduleRequestDto addScheduleRequestDto, Long planId, Long dayId, String memberId);
}
