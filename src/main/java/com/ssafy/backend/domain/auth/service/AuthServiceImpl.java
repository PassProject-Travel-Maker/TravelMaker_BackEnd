package com.ssafy.backend.domain.auth.service;

import com.ssafy.backend.domain.auth.dto.MemberDto.*;
import com.ssafy.backend.domain.auth.mapper.AuthMapper;
import com.ssafy.backend.util.JWTUtil;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final AuthMapper authMapper;
    private final JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public String join(JoinRequestDto joinRequestDto) {
        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(joinRequestDto.getPassword());
        joinRequestDto.setPassword(encodedPassword);

        //DB에 저장
        authMapper.join(joinRequestDto);

        //토큰 만들어서 반환
        return jwtUtil.generateToken(joinRequestDto);
    }

    @Override
    public String login(FindMemberByIdDto loginInfo) {
        return null;
    }
}
