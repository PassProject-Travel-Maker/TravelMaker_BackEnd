package com.ssafy.backend.domain.board.model;

import java.time.LocalDate;

import com.ssafy.backend.domain.auth.model.Member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Board {
	
	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member_id;
	
	private String title;
	private String contents;
	private int hit;
	private LocalDate registertime;

}
