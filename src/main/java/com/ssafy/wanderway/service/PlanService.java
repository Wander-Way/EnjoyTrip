package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.dto.PlanFormDto;
import com.ssafy.wanderway.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanService{
    private final PlanRepository planRepository;


    public Long saveNewPlan(PlanFormDto dto, Member member) {
        // plan테이블에 필드 저장

        // plan의 routes에 데이터 추가 + routes의 routeDetails 데이터 추가

        return null;
    }
}
