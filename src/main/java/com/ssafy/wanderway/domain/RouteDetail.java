package com.ssafy.wanderway.domain;

import com.ssafy.wanderway.dto.LocationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "route_detail")
public class RouteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="place_name") //address의 name이랑 겹치지않나,,, 일단 null로두자
    private String placeName;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;

    //여행 순서
    private int sort;

    //연관관계 편의 메소드
    public void setAll(Route route, LocationDto dto, int sort){
        this.route = route;
        this.sort = sort;
        this.address = Address.builder()
                        .locationDto(dto)
                        .build();
    }

}
