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
}
