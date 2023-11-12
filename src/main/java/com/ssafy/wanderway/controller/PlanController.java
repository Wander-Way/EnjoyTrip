package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.domain.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PlanController {

    /** 다른사람의 플랜 폼 검색
     * @param location
     * @return
     */
    @PostMapping("/find-plan")
    public ResponseEntity getNewPlan(@RequestBody String location){
        return null;
    }

    @PostMapping("/plan")
    public ResponseEntity getNewPlan(@RequestBody Map<Integer, Address[]> location){
        return null;
    }



}
