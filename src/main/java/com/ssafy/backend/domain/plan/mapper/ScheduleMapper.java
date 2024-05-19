package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.dto.ScheduleDto.*;
import com.ssafy.backend.domain.plan.model.Schedule;

import java.util.List;

public interface ScheduleMapper {
    void insertSchedule(List<Schedule> scheduleList);

    List<ScheduleDetailResponseDto> getScheduleDetailList(Long dayId);
}
