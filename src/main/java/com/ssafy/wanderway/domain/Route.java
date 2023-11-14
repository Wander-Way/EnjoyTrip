package com.ssafy.wanderway.domain;

import com.ssafy.wanderway.dto.LocationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @OneToMany(mappedBy = "route", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RouteDetail> routeDetails = new ArrayList<>();
    
    //연관관계편의 메소드
    public void setPlanAndDayAndRd(Plan plan, int day, List<LocationDto> routeDetail){
        this.plan = plan;
        this.day = day;
        for (int sort = 0; sort < routeDetail.size(); sort++) {
            LocationDto dto = routeDetail.get(sort);
            RouteDetail rd = new RouteDetail();
            rd.setAll(this, dto, sort);
            this.routeDetails.add(rd);
        }
    }


}
