package com.ssafy.backend.domain.plan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Sido {

    @Id
    @Column(name = "sido_code")
    private int sidoCode;

    @Column(name = "sido_name")
    private String sidoName;
}
