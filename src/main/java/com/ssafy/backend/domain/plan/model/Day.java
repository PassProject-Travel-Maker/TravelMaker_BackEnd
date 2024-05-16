package com.ssafy.backend.domain.plan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Day {

	@Id
	@Column(name="day_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int num;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id")
	private Plan plan_id;
}
