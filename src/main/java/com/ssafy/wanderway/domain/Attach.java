package com.ssafy.wanderway.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/** 핫플레이스 사진정보를 저장하는 엔티티 : Hotplace의 기본키와 매핑
 * @author 최서현
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name = "attach")
public class Attach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path; //저장경로

    @ManyToOne
    @JoinColumn(name = "hotplace_id")
    private Hotplace hotplace;
}
