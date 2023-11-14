package com.ssafy.wanderway.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;


//저장할 관광플랜의 위치데이터 정의하는 DTO
@Getter @ToString
@NoArgsConstructor
public class LocationDto {

    private String name; //장소명

    private String city; //시도
    private String district; //구군
    private String town; //읍면동
    private String detailAddress; //상세주소

    private Float latitude; //위도
    private Float longitude; //경도



}
