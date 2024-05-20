package com.ssafy.backend.domain.attraction.model;

import com.ssafy.backend.domain.category.model.Category;
import com.ssafy.backend.domain.gugun.model.Gugun;
import com.ssafy.backend.domain.sido.model.Sido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attraction {

    @Id
    @Column(name = "attraction_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sido_code")
    private Sido sido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gugun_code")
    private Gugun gugun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_code")
    private Category category;

    private String title;
    private String addr;
    private String img;
    private int hit;
    private int recommend;
    private double latitude;
    private double longitude;

    @Enumerated(EnumType.STRING)
    @Column(name = "attr_type")
    protected AttrType attrType;

}
