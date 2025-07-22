package com.smhrd.sangspoon.member.service;

import com.smhrd.sangspoon.member.entity.MemberEntity;
import com.smhrd.sangspoon.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원가입
    public void registerMember(MemberEntity member) {
        // loginId 중복 체크
        if(memberRepository.findByLoginId(member.getLoginId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        // 이메일 중복 검사
        if(memberRepository.findByEmail(member.getEmail()) != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        memberRepository.save(member);
    }

    // 로그인
    public MemberEntity login(String loginId, String password){
        MemberEntity member = memberRepository.findByLoginId(loginId);

        if (member != null && member.getPassword().equals(password)) {
            return member;
        }
        else {
            return null;
        }
    }
}
