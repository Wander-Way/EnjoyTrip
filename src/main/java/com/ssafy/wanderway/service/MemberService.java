package com.ssafy.wanderway.service;


import com.ssafy.wanderway.domain.Like;
import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.dto.MemberDto;
import com.ssafy.wanderway.dto.MyInfoRequestDto;
import com.ssafy.wanderway.dto.PlanDto;
import com.ssafy.wanderway.dto.RouteDto;
import com.ssafy.wanderway.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ssafy.wanderway.domain.LikeType.Plan;

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


    public List<RouteDto> mypagePlanList(MyInfoRequestDto myInfoRequestDto) {
        Member member = memberRepository.findByEmail(myInfoRequestDto.getEmail());
        List<RouteDto> myPlanList = new ArrayList<>();
        for (int i = 0; i < member.getRoutes().size(); i++) {
            myPlanList.add(new RouteDto(member.getRoutes().get(i)));
        }
        return myPlanList;
    }

    public List<RouteDto> mypageLikeList(MyInfoRequestDto myInfoRequestDto) {
        Member member = memberRepository.findByEmail(myInfoRequestDto.getEmail());
        List<RouteDto> myLikePlanList = new ArrayList<>();
        for(Like like : member.getLiskes()) {
            myLikePlanList.add(new RouteDto(like.getPlan()));
        }
        return myLikePlanList;
    }

    public MemberDto login(MyInfoRequestDto myinforequestdto) {
        Member member = memberRepository.findByEmail(myinforequestdto.getEmail());
        if(member == null)
            return null;
        MemberDto memberDto = new MemberDto(member);
        return memberDto;
    }

    public MemberDto findPw(String email) {
        Member member = memberRepository.findByEmail(email);
        if(member == null)
            return null;
        MemberDto memberDto = new MemberDto(member);
        return memberDto;
    }
    public MemberDto findMemberByEmail(String email) {
        Member member = memberRepository.findByEmail(email);
        if(member == null)
            return null;
        MemberDto memberDto = new MemberDto(member);
        return memberDto;
    }
}
