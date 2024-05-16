package com.ssafy.backend.domain.auth.mapper;

import com.ssafy.backend.domain.auth.dto.MemberDto.*;
import com.ssafy.backend.domain.auth.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthMapper {
    int join(JoinRequestDto joinInfo);

    Member findById(String id);
}
