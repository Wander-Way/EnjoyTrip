package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.dto.RouteDto;
import com.ssafy.wanderway.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteService {
    //사람들이 공유한 루트를 조회하는 서비스와 관련된 메소드를 작성합니다.
    private final PlanRepository planRepository;

    public List<RouteDto> getRouteRecent3() {
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC, "id"));
        Page<Plan> plans = planRepository.findAll(pageRequest);
        List<RouteDto> routeDtos = new ArrayList<>();
        for(Plan plan : plans) routeDtos.add(RouteDto.builder().plan(plan).build());
        return routeDtos;
    }

}
