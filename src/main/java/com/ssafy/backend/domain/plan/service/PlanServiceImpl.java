package com.ssafy.backend.domain.plan.service;

import com.ssafy.backend.domain.map.dto.AttractionDto.*;
import com.ssafy.backend.domain.member.mapper.MemberMapper;
import com.ssafy.backend.domain.member.model.Member;
import com.ssafy.backend.domain.plan.dto.Attraction2Dto;
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
                String attrType = scheduleForPlanDto.getAttrType();

                InsertScheduleDto insertScheduleDto = new InsertScheduleDto(idx++);

                // 이미 디비에 있는지부터 확인
                AttractionInfoDto attractionInfoDto = attractionMapper.findById(attractionId);
//                System.out.println(attractionInfoDto.getId() + " " + attractionInfoDto.getSido_code());

                // KAKAO이고, 없다면 insert
                if(attrType.equals("KAKAO")) {
                    if(attractionInfoDto == null){
                        attractionMapper.insertKakaoAttr(attractionId);
                        attractionInfoDto = attractionMapper.findById(attractionId);
                    }
                }

                Attraction attraction = attractionInfoDto.toEntity();
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

    @Override
    public PlanDetailResponseDto planDetail(Long id) {
        // 1. get Plan detail
        PlanDetailDto planDetailDto = planMapper.findById(id);
        if(planDetailDto == null) return null;
        Plan plan = planDetailDto.toEntity();

        // 2. get Day detail
        List<DayDetailResponseDto> dayDetailResponseDtoList = dayMapper.getDayDetailList(plan.getId());

        // 3. get Schedule detail
        for (DayDetailResponseDto dayDetailResponseDto : dayDetailResponseDtoList) {
            Long dayId = dayDetailResponseDto.getId();
            List<ScheduleDetailResponseDto> scheduleDetailResponseDtoList
                    = scheduleMapper.getScheduleDetailList(dayId);

            for (ScheduleDetailResponseDto scheduleDetailResponseDto : scheduleDetailResponseDtoList) {
                Long scheduleId = scheduleDetailResponseDto.getId();
                AttractionIdDto attractionIdDto = scheduleMapper.findAttrIdById(scheduleId);

                AttractionInfoDto attractionInfoDto = attractionMapper.findById(attractionIdDto.getId());
                scheduleDetailResponseDto.setAttractionInfoDto(attractionInfoDto);
            }

            dayDetailResponseDto.setScheduleDetailResponseDtoList(scheduleDetailResponseDtoList);
        }

        // return
        PlanDetailResponseDto planDetailResponseDto
                = new PlanDetailResponseDto().toResponseDto(plan, dayDetailResponseDtoList);
        return planDetailResponseDto;
    }

    @Override
    @Transactional
    public String deletePlan(Long id) {
        Long planId = planMapper.findById(id).getId();
        if(planId == null) return "삭제할 여행이 없습니다.";

        List<DayIdDto> dayList = dayMapper.getDayList(planId);
        for (DayIdDto dayIdDto : dayList) {
            Long dayId = dayIdDto.getId();

            // 1. delete scheduleList
            List<ScheduleIdDto> scheduleList = scheduleMapper.getScheduleList(dayId);
            scheduleMapper.deleteAll(scheduleList);
        }

        // 2. delete dayList
        dayMapper.deleteAll(dayList);

        // 3. delete plan
        planMapper.delete(planId);

        return "삭제 완료";
    }
}
