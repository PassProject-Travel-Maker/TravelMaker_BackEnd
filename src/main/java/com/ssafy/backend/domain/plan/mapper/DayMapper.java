package com.ssafy.backend.domain.plan.mapper;

import com.ssafy.backend.domain.plan.model.Day;
import com.ssafy.backend.domain.plan.model.Plan;

import java.util.List;

public interface DayMapper {

    void insertDay(List<Day> dayList);
}
