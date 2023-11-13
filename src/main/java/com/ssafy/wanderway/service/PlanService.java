package com.ssafy.wanderway.service;

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


    public Long saveNewPlan(PlanFormDto planFormDTO) {
        //planRepository.save(); //

        return null;
    }
}
