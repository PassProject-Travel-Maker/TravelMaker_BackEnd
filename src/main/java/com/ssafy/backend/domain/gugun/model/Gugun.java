package com.ssafy.backend.domain.gugun.model;

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
