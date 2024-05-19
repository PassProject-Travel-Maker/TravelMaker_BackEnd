package com.ssafy.backend.domain.plan.model;

import com.ssafy.backend.domain.common.model.BaseTimeEntity;
import com.ssafy.backend.domain.member.model.Member;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Plan extends BaseTimeEntity {
	
	@Id
	@Column(name="plan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	@Column(name = "img_url")
	private String imgUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

}
