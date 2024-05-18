package com.ssafy.backend.domain.auth.service;

import com.ssafy.backend.domain.auth.dto.AuthDto.*;

public interface AuthService {
	String join(JoinRequestDto joinInfo);

	String login(LoginRequestDto loginInfo);

}
