package com.ssafy.backend.domain.auth.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.backend.domain.auth.dto.MemberDto;
import com.ssafy.backend.domain.auth.dto.MemberDto.JoinRequestDto;
import com.ssafy.backend.domain.auth.dto.MemberDto.TestDto;
import com.ssafy.backend.domain.auth.dto.MemberDto.TestResponseDto;
import com.ssafy.backend.domain.auth.model.Member;

public interface AuthMapper {
	int join(JoinRequestDto joinInfo);

	TestResponseDto findById(String id);

}
