package com.ssafy.wanderway.service;


import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.dto.MemberDto;
import com.ssafy.wanderway.dto.MyInfoRequestDto;
import com.ssafy.wanderway.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public void signup(MemberDto memberDto) {
        Member member = new Member(memberDto);
        memberRepository.save(member);
    }
    public MemberDto mypage(MyInfoRequestDto myInfoRequestDto) {
        Member member = memberRepository.findByEmail(myInfoRequestDto.getEmail());
        MemberDto memberDto = new MemberDto(member);
        return memberDto;        
        
    }
    public void mypageEdit(MemberDto memberDto){
        Member member = memberRepository.findByEmail(memberDto.getEmail());
        member.modifyMember(memberDto);

        memberRepository.save(member);
    }

}
