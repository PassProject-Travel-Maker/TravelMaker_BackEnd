package com.ssafy.backend.domain.plan.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ssafy.backend.domain.member.model.Member;
import com.ssafy.backend.domain.plan.dto.DayDto.*;
import com.ssafy.backend.domain.plan.model.Plan;
import lombok.*;

public class PlanDto {

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    public static class CreatePlanRequestDto {
        private String title;
        private String description;
        private String imgUrl;
        private List<DayForPlanDto> dayForPlanDtoList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertPlanDto {
        private String title;
        private String description;
        private String imgUrl;

        public Plan toEntity(Member member) {
            return Plan.builder()
                    .title(this.title)
                    .description(this.description)
                    .imgUrl(this.imgUrl)
                    .member(member)
                    .build();
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyPlanDto {
        private String id;
        private String title;
        private String description;
        private String imgUrl;
        private LocalDateTime createdDate;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlanDetailDto {
        private Long id;
        private String title;
        private String description;
        private String imgUrl;
        private Member member;

        public Plan toEntity() {
            return Plan.builder()
                    .id(this.id)
                    .title(this.title)
                    .description(this.description)
                    .imgUrl(this.imgUrl)
                    .member(this.member)
                    .build();
        }

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PlanDetailResponseDto {
        private Long id;
        private String title;
        private String description;
        private String imgUrl;
        private List<DayDetailResponseDto> dayDetailResponseDtoList;

        public PlanDetailResponseDto toResponseDto(Plan plan, List<DayDetailResponseDto> dayDetailResponseDtoList) {
            return PlanDetailResponseDto.builder()
                    .id(plan.getId())
                    .title(plan.getTitle())
                    .description(plan.getDescription())
                    .imgUrl(plan.getImgUrl())
                    .dayDetailResponseDtoList(dayDetailResponseDtoList)
                    .build();
        }
    }
}
