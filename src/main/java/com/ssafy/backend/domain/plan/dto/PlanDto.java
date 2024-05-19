package com.ssafy.backend.domain.plan.dto;

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
        private List<DayForPlanDto> dayForPlanDtoList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InsertPlanDto {
        private String title;
        private String description;

        public Plan toEntity(Member member) {
            return Plan.builder()
                    .title(this.title)
                    .description(this.description)
                    .member(member)
                    .build();
        }
    }
}
