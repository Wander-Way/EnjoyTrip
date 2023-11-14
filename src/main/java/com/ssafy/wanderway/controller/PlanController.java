package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.dto.LocationDto;
import com.ssafy.wanderway.dto.PlanFormDto;
import com.ssafy.wanderway.repository.MemberRepository;
import com.ssafy.wanderway.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.jdbc.Null;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;
    private final MemberRepository memberRepository;

    /** 다른사람의 플랜 폼 검색
     * @param location
     * @return
     */
    @PostMapping("/find-plan")
    public ResponseEntity getNewPlan(@RequestBody String location){
        return null;
    }

    /** 작성된 플랜 폼 저장
     * @param  dto
     * @return {id:””}
     */
    @PostMapping("/plan")
    public ResponseEntity<Long> saveNewPlan(@RequestBody PlanFormDto dto){
        Member member = memberRepository.findById(3L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        return new ResponseEntity<>(planService.saveNewPlan(dto,member), HttpStatus.OK);
    }



}
