package com.ssafy.wanderway.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/** Tag정보를 유니크하게 저장하는 엔티티 : TagToPlan에서 사용정보를 연결한다.
 * @author 최서현
 */
@Entity
@Getter
@NoArgsConstructor
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String text;

    @Builder
    Tag(String text){
        this.text = text;
    }

}
