package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.dto.DayDto.*;
import com.ssafy.backend.domain.plan.model.Day;
import com.ssafy.backend.domain.plan.model.Plan;

import java.util.List;

public interface DayMapper {

    void insertDay(List<Day> dayList);

    List<DayDetailResponseDto> getDayDetailList(Long planId);

    List<DayIdDto> getDayList(Long planId);

    void deleteAll(List<DayIdDto> dayList);

    DayDetailDto findById(Long dayId);
}
