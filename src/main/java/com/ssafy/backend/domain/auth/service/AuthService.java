package com.ssafy.backend.domain.auth.service;

import com.ssafy.backend.domain.auth.dto.MemberDto;
import com.ssafy.backend.domain.auth.dto.MemberDto.JoinRequestDto;
import com.ssafy.backend.domain.auth.dto.MemberDto.TestDto;
import com.ssafy.backend.domain.auth.model.Member;

public interface AuthService {
	String join(JoinRequestDto joinInfo);

	String login(TestDto loginInfo);

}
