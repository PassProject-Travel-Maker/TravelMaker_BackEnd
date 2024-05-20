package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.member.dto.MemberDto.*;
import com.ssafy.backend.domain.member.mapper.MemberMapper;
import com.ssafy.backend.domain.member.model.Member;
import com.ssafy.backend.domain.plan.dto.Attraction2Dto.*;
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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final DayMapper dayMapper;
    private final PlanMapper planMapper;
    private final MemberMapper memberMapper;
    private final AttractionMapper attractionMapper;
    private final ScheduleMapper scheduleMapper;

    // TODO: 스케줄 추가 시 attr_type에 따른 insert 추가 등 필ㅎ
    @Override
    public void addSchedule(AddScheduleRequestDto addScheduleRequestDto, Long planId, Long dayId, String memberId) {
        List<AddScheduleDto> addScheuldeDtoList
                = addScheduleRequestDto.getAddScheuldeDtoList();

        // member 객체 생성
        MyInfoDto myInfoDto = memberMapper.findById(memberId);
        Member member = myInfoDto.toEntity();

        // plan 객체 생성
        PlanDetailDto planDetailDto = planMapper.findById(planId);
        Plan plan = planDetailDto.toEntity();

        // day 객체 생성
        DayDetailDto dayDetailDto = dayMapper.findById(dayId);
        Day day = dayDetailDto.toEntity(plan);

        List<Schedule> scheduleList = new ArrayList<>();
        for (AddScheduleDto addScheduleDto : addScheuldeDtoList) {
            Long attractionId = addScheduleDto.getAttractionId();
            String attrType = addScheduleDto.getAttrType();
            int orderIndex = addScheduleDto.getOrderIndex();

            // attraction 객체 생성
            AttractionInfoDto attractionInfoDto = attractionMapper.findById(attractionId);
            Attraction attraction = attractionInfoDto.toEntity();

            // schedule 객체 생성
            InsertScheduleDto insertScheduleDto = new InsertScheduleDto(orderIndex);
            Schedule schedule = insertScheduleDto.toEntity(attraction, day);
            scheduleList.add(schedule);
        }

        // schedule 추가
        scheduleMapper.insertSchedule(scheduleList);
    }
}
