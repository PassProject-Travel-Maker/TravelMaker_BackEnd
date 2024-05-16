package com.ssafy.backend.domain.auth.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	@Id
	@Column(name="member_id")
	private String id;
	
	private String password;
	private String name;
	private String nickname;
	private String email;
	private String addr;

}
