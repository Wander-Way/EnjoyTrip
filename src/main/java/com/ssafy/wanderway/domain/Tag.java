package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    //연관관계 편의 메소드
//    public void setTagToPlan(Plan plan){
//        this.plan = plan;
//        plan.getTags().add(this);
//    }

}
