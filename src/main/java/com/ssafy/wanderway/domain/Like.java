package com.ssafy.wanderway.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "like_info")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LikeType type; //REPLY 또는 ROUTE에 대한 좋아요 구분 : ENUM으로

    //좋아요 누른사람
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //좋아요 누른 대상 Reply
    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply reply;

    // 좋아요 누른 대상 PLAN
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    
    //연관관계 편의 메소드
    public void likePlan(Plan plan, Member member){
        this.plan = plan;
        this.member = member;
        this.type = LikeType.Plan;
    }
}
