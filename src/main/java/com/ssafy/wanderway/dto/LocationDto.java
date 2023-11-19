package com.ssafy.wanderway.dto;


import com.ssafy.wanderway.domain.RouteDetail;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

/** 관광플랜 위치데이터 정의하는 DTO
 * @author 최서현
 */
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

    @Builder
    public LocationDto(RouteDetail routeDetail){
        this.name = routeDetail.getAddress().getCity();
        this.city = routeDetail.getAddress().getCity();
        this.district = routeDetail.getAddress().getDistrict();
        this.town = routeDetail.getAddress().getTown();
        this.detailAddress = routeDetail.getAddress().getDetailAddress();
        this.latitude = routeDetail.getAddress().getLatitude();
        this.longitude = routeDetail.getAddress().getLongitude();
    }

}
