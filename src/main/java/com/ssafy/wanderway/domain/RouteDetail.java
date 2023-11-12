package com.ssafy.wanderway.domain;

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

    @Column(name="place_name")
    private String placeName;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name="route_id")
    private Route route;

    //여행 순서
    private int sort;

}
