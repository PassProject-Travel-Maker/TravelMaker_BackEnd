package com.ssafy.backend.domain.sido.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sido {

    @Id
    @Column(name = "sido_code")
    private int sidoCode;

    @Column(name = "sido_name")
    private String sidoName;
}
