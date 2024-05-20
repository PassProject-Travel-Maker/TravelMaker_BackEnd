package com.ssafy.backend.domain.plan.dto;

import com.ssafy.backend.domain.plan.model.*;
import lombok.*;

public class Attraction2Dto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AttractionInfoDto {
        private Long id;
        private int sidoCode;
        private int gugunCode;
        private int categoryCode;

        private String title;
        private String addr;
        private String img;
        private int hit;
        private int recommend;
        private double latitude;
        private double longitude;
        private AttrType attrType;

        public Attraction toEntity() {
            return Attraction.builder()
                    .id(this.id)
                    .sido(Sido.builder().sidoCode(this.sidoCode).build())
                    .gugun(Gugun.builder().gugunCode(this.gugunCode).build())
                    .category(Category.builder().categoryCode(this.categoryCode).build())
                    .title(this.title)
                    .addr(this.addr)
                    .img(this.img)
                    .hit(this.hit)
                    .recommend(this.recommend)
                    .latitude(this.latitude)
                    .longitude(this.longitude)
                    .attrType(this.attrType)
                    .build();
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AttractionIdDto {
        private Long id;
    }

}
