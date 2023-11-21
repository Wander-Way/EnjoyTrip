package com.ssafy.wanderway.domain;

import com.ssafy.wanderway.dto.HotplaceDto;
import com.ssafy.wanderway.dto.LocationDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** Address엔티티 : Emeddable하게 선언하여 Plan과 Route, Hotplace 엔티티에서 사용 
 * @author 최서현
 */

@Embeddable
@Getter
@NoArgsConstructor
public class Address {

    private String name; //장소명

    @Column(name="tmap_id") //티맵에서 사용하는 아이디
    private Long tmapId;
    //주소
    private String city; //시도
    private String district; //구군
    private String town; //읍면동

    //좌표
    @Column(name = "latitude", columnDefinition = "FLOAT")
    private Float latitude; //위도
    @Column(name = "longitude", columnDefinition = "FLOAT")
    private Float longitude; //경도

    //티맵용 좌표
    @Column(name = "noor_Lat", columnDefinition = "FLOAT")
    private Float noorLat; //위도
    @Column(name = "noor_Lon", columnDefinition = "FLOAT")
    private Float noorLon; //경도

    //상세주소
    @Column(name="detail_Address")
    private String detailAddress;

    @Builder
    Address(LocationDto locationDto){
        this.noorLat = locationDto.getNoorlat();
        this.noorLon = locationDto.getNoorlon();
        this.name = locationDto.getName();
        this.city = locationDto.getCity();
        this.district = locationDto.getDistrict();
        this.town = locationDto.getTown();
        this.latitude = locationDto.getLatitude();
        this.longitude = locationDto.getLongitude();
        this.detailAddress = locationDto.getDetailAddress();
        this.tmapId = locationDto.getTmapId();
    }

    Address(HotplaceDto hotplaceDto){
        this.name = hotplaceDto.getName();
        this.city = hotplaceDto.getCity();
        this.district = hotplaceDto.getDistrict();
        this.town = hotplaceDto.getTown();
        this.latitude = hotplaceDto.getLatitude();
        this.longitude = hotplaceDto.getLongitude();
        this.detailAddress = hotplaceDto.getDetailAddress();

    }

}
