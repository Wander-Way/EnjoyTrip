package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //댓글내용
    private String content;

    //댓글작성자
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    //연결된 글
    @ManyToOne
    @JoinColumn(name = "hotplace_id")
    private Hotplace hotplace;
}
