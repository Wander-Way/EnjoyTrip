package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    private String name; //장소명
    
    //주소
    private String city; //시도
    private String district; //구군
    private String town; //읍면동

    //좌표
    private Long latitude; //위도
    private Long longitude; //경도

    //상세주소
    @Column(name="detail_Address")
    private String detailAddress;
}
