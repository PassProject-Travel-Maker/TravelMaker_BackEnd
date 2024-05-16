package com.ssafy.backend.domain.plan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Gugun {

    @Id
    @Column(name = "gugun_code")
    private int gugunCode;

    @Column(name = "gugun_name")
    private String gugunName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sido_code")
    private Sido sido;
}
