package com.ssafy.backend.domain.auth.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.backend.domain.auth.dto.AuthDto.*;
import com.ssafy.backend.domain.auth.mapper.AuthMapper;
import com.ssafy.backend.util.JWTUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final AuthMapper authMapper;
	private final JWTUtil jwtUtil;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String join(JoinRequestDto joinInfo) {
		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(joinInfo.getPassword());
		joinInfo.setPassword(encodedPassword);

		// DB에 저장
		authMapper.join(joinInfo);

		// 토큰 만들어서 반환
		GenerateTokenDto generateTokenDto = new GenerateTokenDto(joinInfo.getId(), joinInfo.getName());
		return jwtUtil.generateToken(generateTokenDto);
	}

	@Override
	public String login(LoginRequestDto loginInfo) {
		String id = loginInfo.getId();
		String password = loginInfo.getPassword();
		
		// 유효한 아이디인지 조회
		FindMemberByIdDto member = authMapper.findById(id);
		System.out.println("member: " + member.getId());
		if(member==null || !passwordEncoder.matches(password, member.getPassword()) ) return null;
		
		//토큰 만들어서 반환
		GenerateTokenDto generateTokenDto = new GenerateTokenDto(member.getId(), member.getName());
		return jwtUtil.generateToken(generateTokenDto);
	}

	
}
