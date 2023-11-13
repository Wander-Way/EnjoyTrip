package com.ssafy.wanderway.dto;


import lombok.Getter;
import lombok.ToString;

import java.util.Map;

// 사용자가 저장한 관광플랜 폼 데이터를 바인딩할 DTO
@Getter @ToString
public class PlanFormDto {

    private Map<Integer, LocationDto> planFormMap;
}

/**

 {
 “1” : [
 {위치데이터},
 {위치데이터},
 {위치데이터},
 ],
 “2” : [
 {위치데이터},
 {위치데이터},
 {위치데이터},
 ],
 }

 */