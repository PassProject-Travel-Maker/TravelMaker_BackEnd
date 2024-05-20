package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.dto.ScheduleDto.*;
import com.ssafy.backend.domain.plan.dto.Attraction2Dto.*;
import com.ssafy.backend.domain.plan.model.Schedule;

import java.util.List;

public interface ScheduleMapper {
    void insertSchedule(List<Schedule> scheduleList);

    List<ScheduleDetailResponseDto> getScheduleDetailList(Long dayId);

    List<ScheduleIdDto> getScheduleList(Long dayId);

    void deleteAll(List<ScheduleIdDto> scheduleList);

    AttractionIdDto findAttrIdById(Long scheduleId);
}
