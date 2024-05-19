package com.ssafy.backend.domain.plan.dto;

import com.ssafy.backend.domain.plan.model.Attraction;
import com.ssafy.backend.domain.plan.model.Category;
import com.ssafy.backend.domain.plan.model.Gugun;
import com.ssafy.backend.domain.plan.model.Sido;
import lombok.*;

public class Attraction2Dto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AttractionInfoDto {
        private Long id;
        private Sido sido;
        private Gugun gugun;
        private Category category;
        private String title;
        private String addr;
        private String img;
        private int hit;
        private int recommend;
        private double latitude;
        private double longitude;

        public Attraction toEntity() {
            return Attraction.builder()
                    .id(this.id)
                    .sido(this.sido)
                    .gugun(this.gugun)
                    .category(this.category)
                    .title(this.title)
                    .addr(this.addr)
                    .img(this.img)
                    .hit(this.hit)
                    .recommend(this.recommend)
                    .latitude(this.latitude)
                    .longitude(this.longitude)
                    .build();
        }
    }

}
