package com.ssafy.backend.domain.auth.service;

import com.ssafy.backend.domain.auth.dto.MemberDto.*;
import com.ssafy.backend.domain.auth.model.Member;

public interface AuthService {
	String join(JoinRequestDto joinInfo);

	String login(LoginRequestDto loginInfo);

}
