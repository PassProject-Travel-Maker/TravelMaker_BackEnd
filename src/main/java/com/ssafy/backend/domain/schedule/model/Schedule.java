package com.ssafy.backend.domain.schedule.model;

import com.ssafy.backend.domain.attraction.model.Attraction;
import com.ssafy.backend.domain.day.model.Day;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
