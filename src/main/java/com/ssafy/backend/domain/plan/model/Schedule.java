package com.ssafy.backend.domain.plan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
	
	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int order;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "day_id")
	private Day day_id;

}
