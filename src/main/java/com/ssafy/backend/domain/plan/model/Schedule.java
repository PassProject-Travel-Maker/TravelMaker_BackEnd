package com.ssafy.backend.domain.plan.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Getter
@NoArgsConstructor
public class Schedule {
	
	@Id
	@Column(name="schedule_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "`order`", nullable = false)
	private int order;
	
	@ManyToOne
	@JoinColumn(name = "day_id")
	private Day day;

	@ManyToOne
	@JoinColumn(name = "attraction_id")
	private Attraction attraction;

}
