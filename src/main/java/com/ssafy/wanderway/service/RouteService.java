package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.Like;
import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.dto.RouteDto;
import com.ssafy.wanderway.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

/** Route, 즉 사람들이 공유한 여행계획 데이터를 관리하는 서비스
 * @author 최서현
 */
@Service
@Transactional
@RequiredArgsConstructor
public class RouteService {
    //사람들이 공유한 루트를 조회하는 서비스와 관련된 메소드를 작성합니다.
    private final PlanRepository planRepository;

    public List<RouteDto> getRouteRecent3(Member member) {
        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC, "id"));
        Page<Plan> plans = planRepository.findAll(pageRequest);
        List<RouteDto> routeDtos = new ArrayList<>();
        for(Plan plan : plans) {
            boolean isLike = plan.getLikes().stream()
                    .anyMatch(like -> like.getMember().getId().equals(member.getId()));

            routeDtos.add(RouteDto.builder().plan(plan).isLike(isLike).build());
        }
        return routeDtos;
    }

    public void likeRoute(Long id, Member member) {
        Plan plan = planRepository.findById(id).orElse(null);
        if(plan == null) throw new NullPointerException("id = "+id+"인 plan이 존재하지 않습니다");
        boolean isLike = plan.getLikes().stream()
                .anyMatch(like -> like.getMember().getId().equals(member.getId()));
        if(isLike) throw new NullPointerException("이미 좋아요를 눌렀습니다.");

        plan.likePlan(plan, member);
    }

    public void cencelLikeRoute(Long id, Member member) {
        Plan plan = planRepository.findById(id).orElse(null);
        if(plan == null) throw new NullPointerException("id = "+id+"인 plan이 존재하지 않습니다");
        boolean isLike = plan.getLikes().stream()
                .anyMatch(like -> like.getMember().getId().equals(member.getId()));
        if(!isLike) throw new NullPointerException("좋아요를 누르지않아 취소가 불가능합니다.");

        //해당 플랜에대한 사용자의 좋아요를 캔슬
        for(Like like : plan.getLikes()){
            if(like.getMember().getId() == member.getId()){
                plan.getLikes().remove(like);
                return;
            }
        }
    }
}
