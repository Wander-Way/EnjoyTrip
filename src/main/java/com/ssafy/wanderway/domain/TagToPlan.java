package com.ssafy.wanderway.domain;

import javax.persistence.*;

@Entity
@Table(name = "tag_to_plan")
public class TagToPlan {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    //연관관계 편의 메소드
    public void setPlan(Plan plan){
        this.plan = plan;
        plan.getTags().add(this);
    }

}