package com.ssafy.backend.domain.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.backend.domain.auth.dto.MemberDto.*;
import com.ssafy.backend.domain.auth.mapper.AuthMapper;
import com.ssafy.backend.domain.auth.model.Member;
import com.ssafy.backend.util.JWTUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final AuthMapper authMapper;
	private final JWTUtil jwtUtil;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String join(TestDto joinInfo) {
		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(joinInfo.getPassword());
		joinInfo.setPassword(encodedPassword);

		// DB에 저장
		authMapper.join(joinInfo);

		// 토큰 만들어서 반환
		return jwtUtil.generateToken(joinInfo);
	}

}
