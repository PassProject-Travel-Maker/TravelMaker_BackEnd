package com.ssafy.backend.domain.day.mapper;

import com.ssafy.backend.domain.day.dto.DayDto.*;
import com.ssafy.backend.domain.day.model.Day;

import java.util.List;

public interface DayMapper {

    void insertDay(List<Day> dayList);

    List<DayDetailResponseDto> getDayDetailList(Long planId);

    List<DayIdDto> getDayList(Long planId);

    void deleteAll(List<DayIdDto> dayList);

    DayDetailDto findById(Long dayId);
}
