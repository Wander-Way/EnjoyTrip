package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.domain.Route;
import com.ssafy.wanderway.domain.Tag;
import com.ssafy.wanderway.dto.PlanFormDto;
import com.ssafy.wanderway.repository.PlanRepository;
import com.ssafy.wanderway.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PlanService{

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
}
