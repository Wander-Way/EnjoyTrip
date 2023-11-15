package com.ssafy.wanderway.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/** 다른사람의 플랜 폼을 검색하여 플랜세우기에 사용할수 있도록 하는 DTO
 * @author 최서현
 */
@Getter
@ToString
@NoArgsConstructor
public class PlanDto {

    private String nickname;
    private String profile;
    private String title;
    private String description;
    private Map<Integer, List<LocationDto>> plan;

    @Builder
    public PlanDto(String nickname, String profile, String title,
                   String description, Map<Integer, List<LocationDto>> locationDtos) {
        this.nickname = nickname;
        this.profile = profile;
        this.title = title;
        this.description = description;
        this.plan = locationDtos;
    }
}
