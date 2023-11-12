package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "route")
public class Route {
    //한 여행계획에 존재하는 !일별! 루트계획 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="plan_id")
    private Plan plan;

    //DAY 카운트 = 일 구분
    private int day;

    //일별 루트 저장
    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY)
    private List<RouteDetail> routeDetails = new ArrayList<>();


}
