package com.ssafy.backend.domain.auth.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backend.domain.auth.dto.MemberDto;
import com.ssafy.backend.domain.auth.dto.MemberDto.TestDto;
import com.ssafy.backend.domain.auth.model.Member;

public interface AuthMapper {
	int join(TestDto joinInfo);

}
