package com.ssafy.backend.domain.member.service;

import com.ssafy.backend.domain.member.dto.MemberDto.*;
import com.ssafy.backend.domain.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public MyInfoDto myInfo(String id) {
        MyInfoDto memberById = memberMapper.findById(id);
        return memberById;
    }
}
