package com.ssafy.backend.domain.plan.dto;

import com.ssafy.backend.domain.member.model.Member;
import com.ssafy.backend.domain.plan.model.Day;
import com.ssafy.backend.domain.plan.model.Plan;
import lombok.*;

import java.util.List;
import com.ssafy.backend.domain.plan.dto.ScheduleDto.*;

public class DayDto {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DayForPlanDto {
        private int num;
        private List<ScheduleForPlanDto> scheduleForPlanDtoList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertDayDto {
        private int num;

        public Day toEntity(Plan plan) {
            return Day.builder()
                    .num(this.num)
                    .plan(plan)
                    .build();
        }
    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DayDetailResponseDto {
        private Long id;
        private int num;
        private List<ScheduleDetailResponseDto> scheduleDetailResponseDtoList;

        public DayDetailResponseDto toResponseDto(Day day, List<ScheduleDetailResponseDto> scheduleDetailResponseDtoList) {
            return DayDetailResponseDto.builder()
                    .id(day.getId())
                    .num(day.getNum())
                    .scheduleDetailResponseDtoList(scheduleDetailResponseDtoList)
                    .build();
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DayIdDto {
        private Long id;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DayDetailDto {
        private Long id;
        private int num;

        public Day toEntity(Plan plan) {
            return Day.builder()
                    .id(this.id)
                    .num(this.num)
                    .plan(plan)
                    .build();
        }
    }

}
