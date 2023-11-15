package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.*;
import com.ssafy.wanderway.dto.FindPlanDto;
import com.ssafy.wanderway.dto.LocationDto;
import com.ssafy.wanderway.dto.PlanDto;
import com.ssafy.wanderway.dto.PlanFormDto;
import com.ssafy.wanderway.repository.PlanRepository;
import com.ssafy.wanderway.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.stream.Location;
import java.util.*;

/** Plan, 즉 새로운 여행계획을 세울때 필요한 서비스
 * @author 최서현
 */
@Service
@Transactional
@RequiredArgsConstructor
public class PlanService{
    //Plan을 새로 만드는 서비스와 관련된 로직을 작성합니다

    private final PlanRepository planRepository;
    private final TagRepository tagRepository;

    public Long saveNewPlan(PlanFormDto dto, Member member) {
        // 1.Tag를 유니크하게 저장 -> PlanToTag를 만들어 Plan에 연결한다.
        List<Tag> savedTags = new ArrayList<>();
        for(String text : dto.getTags()) {
            Tag tag = tagRepository.findByText(text);
            if(tag == null) {
                Tag newTag = Tag.builder().text(text).build();
                tagRepository.saveAndFlush(newTag);
                savedTags.add(newTag);
            }else savedTags.add(tag);
        }

        // 2.plan 저장 (로직중 Route를 같이 생성하여 저장시킴)
        Plan newPlan = Plan.builder()
                            .planFormDto(dto)
                            .member(member)
                            .savedTags(savedTags)
                            .build();
        planRepository.saveAndFlush(newPlan);

        return newPlan.getId();
    }

    public List<PlanDto> findByCity(FindPlanDto findPlanDto) {
        PageRequest pageRequest = PageRequest.of(findPlanDto.getPage()-1,3, Sort.by(Sort.Direction.DESC, "id"));
        Page<Plan> plans = planRepository.findByLocationCityContaining(findPlanDto.getKeyword(),pageRequest);

        List<PlanDto> planForms = new ArrayList<>();
        for(Plan plan : plans.getContent()){
            PlanDto planDto = PlanDto.builder()
                    .nickname(plan.getMember().getNickname())
                    .profile(plan.getMember().getProfile())
                    .title(plan.getTitle())
                    .description(plan.getDescription())
                    .locationDtos(routesToLocationDtos(plan.getRoutes()))
                    .build();
            planForms.add(planDto);
        }
        return planForms;
    }

    //List<Route> routes를 통해 경로를 재조립하여 Map<Integer, List<LocationDto>>형태를 리턴하는 메소드
    public static Map<Integer, List<LocationDto>> routesToLocationDtos (List<Route> routes){
        Map<Integer, List<LocationDto>> result = new HashMap<>();
        for(Route route : routes){
            List<LocationDto> locationDtos = new ArrayList<>();
            for(RouteDetail rd : route.getRouteDetails()) locationDtos.add(LocationDto.builder().routeDetail(rd).build());
            result.put(route.getDay(), locationDtos);
        }
        return result;
    }

    public void modifyIspublic(Long id) {
        Plan plan = planRepository.findById(id).orElse((null));;
        if(plan == null) throw new NullPointerException("id = "+id+"인 plan 객체는 존재하지 않습니다");
        plan.modifyIspublic();
    }
}
