package com.ssafy.wanderway.domain;


import com.ssafy.wanderway.dto.LocationDto;
import com.ssafy.wanderway.dto.PlanFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.*;

/** 여행계획을 저장하는 엔티티 : 태그목록, 좋아요목록, 그리고 루트목록(일별테이블)를 가진다.
 * @author 최서현
 */
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
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    //태그리스트
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TagToPlan> tags = new HashSet<>();

    //좋아요리스트
    @OneToMany(mappedBy = "plan",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes = new ArrayList<>();

    //일별 루트
    @OneToMany(mappedBy = "plan",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Route> routes = new ArrayList<>();

    @Builder
    Plan(PlanFormDto planFormDto, Member member, List<Tag> savedTags){
        this.title = planFormDto.getTitle();
        this.description = planFormDto.getDescription();
        this.thumbnail = null;
        this.location = Address.builder()
                        .locationDto(planFormDto.getLocation())
                        .build();
        this.member = member;
        for(Tag tag : savedTags){
            TagToPlan tagToPlan = new TagToPlan();
            tagToPlan.setTagToPlan(this, tag);
            this.tags.add(tagToPlan);
        }
        // Map<Integer, List<LocationDto>> plan의 Integer = DAY값
        for(Integer day : planFormDto.getPlan().keySet()){
            Route newRoute = new Route();
            newRoute.setPlanAndDayAndRd(this, day, planFormDto.getPlan().get(day));
            routes.add(newRoute);
        }

    }

    //공개여부를 수정하는 메소드
    public void modifyIspublic(){
        this.isPublic = !this.isPublic;
    }


    //==연관관계 편의메소드 이용
    public void likePlan(Plan plan, Member member) {
        Like newLike = new Like();
        newLike.likePlan(this, member);
        likes.add(newLike);
    }
}
