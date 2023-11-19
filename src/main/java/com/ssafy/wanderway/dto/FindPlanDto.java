package com.ssafy.wanderway.dto;

import lombok.Getter;
import lombok.ToString;

/** 다른사람의 플랜 검색에 사용하는 DTO
 * @author 최서현
 */
@Getter @ToString
public class FindPlanDto {
    private int page;
    private String keyword;



}
