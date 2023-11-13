package com.ssafy.wanderway.domain;


import com.ssafy.wanderway.dto.LocationDto;
import com.ssafy.wanderway.dto.PlanFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "plan")
public class Plan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String thumbnail;

    //공유여부 : true일때 공개
    @Column(name="is_public")
    @ColumnDefault("false")
    private boolean isPublic;

    @Embedded
    private Address location;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //태그리스트
    @OneToMany(mappedBy = "plan")
    private Set<TagToPlan> tags = new HashSet<>();

    //좋아요리스트
    @OneToMany(mappedBy = "plan",fetch = FetchType.LAZY)
    private List<Like> likes = new ArrayList<>();

    //일별 루트
    @OneToMany(mappedBy = "plan",fetch = FetchType.LAZY)
    private List<Route> routes = new ArrayList<>();

    @Builder
    Plan(PlanFormDto dto, Member member){
        this.title = dto.getTitle();
        this.description = dto.getDescription();
        this.thumbnail = null;
        this.location = new Address(dto.getLocation());
        this.member = member;
        //List<String> tags;

        //태그는 tag테이블에 존재하면 그 id를, 없으면 저장후의 id를 꺼내서 tag_to_plan에 plan과 함께 매칭한다.

        //Map<Integer, List<LocationDto>> plan;

    }


}
