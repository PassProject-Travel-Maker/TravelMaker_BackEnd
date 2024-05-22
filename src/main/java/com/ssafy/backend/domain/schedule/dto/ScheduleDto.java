package com.ssafy.backend.domain.schedule.dto;

import com.ssafy.backend.domain.attraction.model.Attraction;
import com.ssafy.backend.domain.day.model.Day;
import com.ssafy.backend.domain.schedule.model.Schedule;
import lombok.*;
import com.ssafy.backend.domain.attraction.dto.Attraction2Dto.*;

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
        private KakaoDto kakaoDto;
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
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleDetailResponseDto {
        private Long id;
        private int orderIndex;
        private AttractionInfoDto2 attractionInfoDto2;

        public ScheduleDetailResponseDto toResponseDto(Schedule schedule, AttractionInfoDto2 attractionInfoDto2) {
            return ScheduleDetailResponseDto.builder()
                    .id(schedule.getId())
                    .orderIndex(schedule.getOrder())
                    .attractionInfoDto2(attractionInfoDto2)
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
        private int orderIndex;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleIdDto {
        private Long id;
    }

}
