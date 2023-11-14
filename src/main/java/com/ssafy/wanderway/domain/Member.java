package com.ssafy.wanderway.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String profile;

    //작성한 여행플랜
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Plan> routes = new ArrayList<>();

    //좋아요한 목록
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Like> liskes = new ArrayList<>();

    //댓글목록
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Reply> replies = new ArrayList<>();

    @Builder
    public  Member (String email, String password, String nickname){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.profile = "/default.img";
    }

}
