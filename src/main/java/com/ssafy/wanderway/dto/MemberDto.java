package com.ssafy.wanderway.dto;

import com.ssafy.wanderway.domain.Member;
import lombok.*;

//@Data
@Getter
@NoArgsConstructor
@ToString
@Setter
//@ApiModel(value   = "MemberDto : 맴버 정보")
public class MemberDto {

  private Long id;//생략
  private String email;
  private String password;
  private String nickname;
  private String profile;



  public MemberDto (Member member){
    this.email = member.getEmail();
    this.password = member.getPassword(); 
    this.nickname = member.getNickname(); 
    this.profile = member.getProfile(); 
  }


}
