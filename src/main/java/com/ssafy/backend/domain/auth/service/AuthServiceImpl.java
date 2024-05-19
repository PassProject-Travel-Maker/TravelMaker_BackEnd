package com.ssafy.backend.domain.auth.service;

import com.ssafy.backend.domain.plan.dto.PlanDto.*;
import com.ssafy.backend.domain.plan.mapper.PlanMapper;
import com.ssafy.backend.domain.plan.service.PlanService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.backend.domain.auth.dto.AuthDto.*;
import com.ssafy.backend.domain.auth.mapper.AuthMapper;
import com.ssafy.backend.util.JWTUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

	private final AuthMapper authMapper;
	private final PlanMapper planMapper;
	private final JWTUtil jwtUtil;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private final PlanService planService;

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
		if(!passwordEncoder.matches(password, member.getPassword())) return null;
		
		//토큰 만들어서 반환
		GenerateTokenDto generateTokenDto = new GenerateTokenDto(member.getId(), member.getName());
		return jwtUtil.generateToken(generateTokenDto);
	}

	@Override
	@Transactional
	public String deleteMember(String memberId, String password) {
		FindMemberByIdDto member = authMapper.findById(memberId);

		// TODO: 비밀번호가 일치하지 않을 경우
//		if(!password.equals(member.getPassword()))
//			return "비밀번호가 일치하지 않습니다.";

		// 비밀번호가 일치할 경우
		// 1. 해당 사용자가 작성한 여행 모두 삭제
		List<PlanIdDto> planIdList = planMapper.findByMemberId(memberId);
		for (PlanIdDto planIdDto : planIdList) {
			Long planId = planIdDto.getId();
			planService.deletePlan(planId);
		}

		// 2. 사용자 삭제
		authMapper.delete(memberId);

		// TODO: 3. 기타 남아있는 정보 삭제 (token 등)

		return "삭제 완료";
	}


}
