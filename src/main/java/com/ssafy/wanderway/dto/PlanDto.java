package com.ssafy.wanderway.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

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
