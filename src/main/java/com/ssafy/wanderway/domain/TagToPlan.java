package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

/** 존재하는 태그들과 plan의 매핑정보를 저장하는 엔티티
 * @author 최서현
 */
@Entity
@Table(name = "tag_to_plan")
@Getter @ToString
public class TagToPlan {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    //연관관계 편의 메소드
    public void setTagToPlan(Plan plan, Tag tag){
        this.plan = plan;
        this.tag = tag;
        plan.getTags().add(this);
    }

}