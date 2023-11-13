package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.dto.PlanFormDto;
import com.ssafy.wanderway.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PlanController {

    private final PlanService planService;

    /** 다른사람의 플랜 폼 검색
     * @param location
     * @return
     */
    @PostMapping("/find-plan")
    public ResponseEntity getNewPlan(@RequestBody String location){
        return null;
    }

    /** 작성된 플랜 폼 저장
     * @param planFormDTO
     * @return {id:””}
     */
    @PostMapping("/plan")
    public ResponseEntity<Long> saveNewPlan(@RequestBody PlanFormDto planFormDTO){
        Long id = planService.saveNewPlan(planFormDTO);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



}
