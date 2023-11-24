package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.dto.FindPlanDto;
import com.ssafy.wanderway.dto.LocationDto;
import com.ssafy.wanderway.dto.PlanDto;
import com.ssafy.wanderway.dto.PlanFormDto;
import com.ssafy.wanderway.repository.MemberRepository;
import com.ssafy.wanderway.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.Location;
import java.util.List;

/** 새로운 Plan 작성을 주관하는 Controller
 * @author 최서현
 */

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
    public ResponseEntity<List<PlanDto>> getPlan(@RequestBody FindPlanDto findPlanDto){
        //검색 키워드는 location만(city) 가능하다.
        List<PlanDto> planDtos = planService.findByCity(findPlanDto);
        return new ResponseEntity<>(planDtos, HttpStatus.OK);
    }

    /** 작성된 플랜 폼 저장
     * @param  planFormDto
     * @return id
     */
    @PostMapping("/plan")
    public ResponseEntity<Long> saveNewPlan(@RequestBody PlanFormDto planFormDto){
        //==임시 로그인유저 코드블럭
        Member member = memberRepository.findById(13L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        //==

        return new ResponseEntity<>(planService.saveNewPlan(planFormDto,member), HttpStatus.OK);
    }
}
