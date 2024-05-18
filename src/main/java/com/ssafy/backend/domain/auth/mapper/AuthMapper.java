package com.ssafy.backend.domain.auth.mapper;
import com.ssafy.backend.domain.auth.dto.AuthDto.*;

public interface AuthMapper {
	int join(JoinRequestDto joinInfo);
	FindMemberByIdDto findById(String id);
}
