package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.model.Schedule;

import java.util.List;

public interface ScheduleMapper {
    void insertSchedule(List<Schedule> scheduleList);
}
