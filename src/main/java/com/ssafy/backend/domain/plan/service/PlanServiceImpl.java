package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.map.dto.AttractionDto.*;
import com.ssafy.backend.domain.member.mapper.MemberMapper;
import com.ssafy.backend.domain.member.model.Member;
import com.ssafy.backend.domain.plan.dto.DayDto.*;
import com.ssafy.backend.domain.plan.dto.PlanDto.*;
import com.ssafy.backend.domain.plan.dto.ScheduleDto.*;
import com.ssafy.backend.domain.plan.mapper.AttractionMapper;
import com.ssafy.backend.domain.plan.mapper.DayMapper;
import com.ssafy.backend.domain.plan.mapper.PlanMapper;
import com.ssafy.backend.domain.plan.mapper.ScheduleMapper;
import com.ssafy.backend.domain.plan.model.Attraction;
import com.ssafy.backend.domain.plan.model.Day;
import com.ssafy.backend.domain.plan.model.Plan;
import com.ssafy.backend.domain.plan.model.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanServiceImpl implements PlanService {

    private final MemberMapper memberMapper;
    private final PlanMapper planMapper;
    private final DayMapper dayMapper;
    private final AttractionMapper attractionMapper;
    private final ScheduleMapper scheduleMapper;

    @Override
    @Transactional
    public void createPlan(String memberId, CreatePlanRequestDto createPlanRequestDto) {

        // 1. save plan
        InsertPlanDto insertPlanDto = new InsertPlanDto(
                createPlanRequestDto.getTitle(),
                createPlanRequestDto.getDescription(),
                createPlanRequestDto.getImgUrl());

        Member member = memberMapper.findById(memberId).toEntity();
        Plan plan = insertPlanDto.toEntity(member);
        planMapper.insertPlan(plan);
        System.out.println("plan id: " + plan.getId());

        // 2. save day
        List<DayForPlanDto> dayForPlanDtoList = createPlanRequestDto.getDayForPlanDtoList();
        List<Day> dayList = new ArrayList<>();
        for (DayForPlanDto dayForPlanDto : dayForPlanDtoList) {
            InsertDayDto insertDayDto = new InsertDayDto(dayForPlanDto.getNum());

            Day day = insertDayDto.toEntity(plan);
            dayList.add(day);
            System.out.println(day.getNum() + " " + plan.getId());
        }
        dayMapper.insertDay(dayList);

        // 3. save schedule
        for (int i = 0; i < dayList.size(); i++) {
            Day day = dayList.get(i);
            DayForPlanDto dayForPlanDto = dayForPlanDtoList.get(i);

            List<ScheduleForPlanDto> scheduleForPlanDtoList
                    = dayForPlanDto.getScheduleForPlanDtoList();
            List<Schedule> scheduleList = new ArrayList<>();

            int idx = 0;
            for (ScheduleForPlanDto scheduleForPlanDto : scheduleForPlanDtoList) {
                Long attractionId = scheduleForPlanDto.getAttractionId();
                InsertScheduleDto insertScheduleDto = new InsertScheduleDto(idx++);
                System.out.println("하이 " + attractionId);
                Attraction attraction = attractionMapper.findById(attractionId).toEntity();

                Schedule schedule = insertScheduleDto.toEntity(attraction, day);
                scheduleList.add(schedule);
            }

             scheduleMapper.insertSchedule(scheduleList);
        }

    }

    @Override
    public List<MyPlanDto> myPlanList(String memberId) {
        List<MyPlanDto> myPlanDtoList = planMapper.getMyPlan(memberId);
        return myPlanDtoList;
    }
}
