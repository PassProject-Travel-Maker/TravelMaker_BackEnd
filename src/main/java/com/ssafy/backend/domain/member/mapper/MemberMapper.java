package com.ssafy.backend.domain.member.mapper;

import com.ssafy.backend.domain.member.dto.MemberDto.*;

public interface MemberMapper {
    TestRespDto findById(String id);
}
