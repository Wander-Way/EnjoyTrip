package com.ssafy.wanderway.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private List<Route> routeDetails = new ArrayList<>();


}
