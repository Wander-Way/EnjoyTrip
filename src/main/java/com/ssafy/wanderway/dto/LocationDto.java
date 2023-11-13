package com.ssafy.wanderway.dto;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;


//저장할 관광플랜의 위치데이터 정의하는 DTO
@Getter @ToString
public class LocationDto {

    private String name; //장소명

    private String city; //시도
    private String district; //구군
    private String town; //읍면동

    private Long latitude; //위도
    private Long longitude; //경도

    //상세주소
    private String detailAddress;

}
