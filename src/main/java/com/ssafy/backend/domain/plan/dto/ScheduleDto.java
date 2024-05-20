package com.ssafy.backend.domain.plan.dto;

import com.ssafy.backend.domain.plan.model.Attraction;
import com.ssafy.backend.domain.plan.model.Day;
import com.ssafy.backend.domain.plan.model.Schedule;
import lombok.*;

import java.util.List;

public class ScheduleDto {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleForPlanDto {
        private Long attractionId;
        private String attrType;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertScheduleDto {
        private int order;

        public Schedule toEntity(Attraction attraction, Day day) {
            return Schedule.builder()
                    .order(this.order)
                    .attraction(attraction)
                    .day(day)
                    .build();
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleDetailResponseDto {
        private Long id;
        private int orderIndex;
        private Long attractionId;

        public ScheduleDetailResponseDto toResponseDto(Schedule schedule) {
            return ScheduleDetailResponseDto.builder()
                    .id(schedule.getId())
                    .orderIndex(schedule.getOrder())
                    .attractionId(schedule.getAttraction().getId())
                    .build();
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddScheduleRequestDto {
        List<AddScheduleDto> addScheuldeDtoList;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddScheduleDto {
        private Long attractionId;
        private String attrType;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleIdDto {
        private Long id;
    }

}
