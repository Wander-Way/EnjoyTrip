package com.ssafy.wanderway.domain;

import com.ssafy.wanderway.dto.HotplaceDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/** 핫플레이스 정보를 저장하는 엔티티 : 사진, 댓글목록, 좋아요목록을 가진다.
 * @author 최서현
 */

@Entity
@Getter
@NoArgsConstructor
@ToString
@Table(name = "hotplace")
public class Hotplace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String title; //장소이름 : 해동용궁사
    private Long hit; //조회수
    private String content; //상세정보

    @Embedded
    private Address address;

    // 문의및 안내, 홈페이지, 주소, 이용시간, 휴일, 화장실 컬럼 추가 필요한가?

    //사진
    @OneToMany(mappedBy = "hotplace", fetch = FetchType.LAZY)
    private List<Attach> attaches = new ArrayList<>();

    //댓글목록
    @OneToMany(mappedBy="hotplace", fetch = FetchType.LAZY)
    private List<Reply> replies = new ArrayList<>();

    //좋아요목록
    @OneToMany(mappedBy = "reply",fetch = FetchType.LAZY)
    private List<Like> likes = new ArrayList<>();

    public Hotplace(HotplaceDto dto){
        this.title = dto.getTitle();
        this.hit = dto.getHit();
        this.content = dto.getContent();

        address = new Address(dto);


        //this.address = dto.getDetailAddress();
        //Attach attach = new Attach(this, dto);
        //this.attaches.add(attach);
    }
    public void increaseHit(){
        this.hit++;
    }
}
