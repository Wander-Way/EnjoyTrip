package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


/** 댓글을 저장하는 엔티티 : 핫플레이스 게시글에 달린 댓글을 저장하는 엔티티,
 *  member와 hotplace의 기본키를 외래키로 가진다.
 * @author 최서현
 */

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

    //댓글 남긴 일자
    @Column(name = "created_date")
    private Date date;

}
