package com.ssafy.backend.domain.auth.service;

import com.ssafy.backend.domain.auth.dto.MemberDto.*;

public interface AuthService {

    String join(JoinRequestDto joinRequestDto);
    String login(FindMemberByIdDto loginInfo);
}
