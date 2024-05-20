package com.ssafy.backend.domain.day.model;

import com.ssafy.backend.domain.plan.model.Plan;
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
public class Day {

	@Id
	@Column(name="day_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int num;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id")
	private Plan plan;
}
