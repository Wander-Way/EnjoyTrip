package com.ssafy.wanderway.dto;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class FindPlanDto {
    private int page;
    private String keyword;
}
