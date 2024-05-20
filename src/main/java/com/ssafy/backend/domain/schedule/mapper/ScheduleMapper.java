package com.ssafy.backend.domain.schedule.mapper;

import com.ssafy.backend.domain.schedule.dto.ScheduleDto.*;
import com.ssafy.backend.domain.attraction.dto.Attraction2Dto.*;
import com.ssafy.backend.domain.schedule.model.Schedule;

import java.util.List;

public interface ScheduleMapper {
    void insertSchedule(List<Schedule> scheduleList);

    List<ScheduleDetailResponseDto> getScheduleDetailList(Long dayId);

    List<ScheduleIdDto> getScheduleList(Long dayId);

    void deleteAll(List<ScheduleIdDto> scheduleList);

    AttractionIdDto findAttrIdById(Long scheduleId);
}
