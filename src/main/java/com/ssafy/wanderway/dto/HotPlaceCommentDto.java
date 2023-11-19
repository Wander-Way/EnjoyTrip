package com.ssafy.wanderway.dto;


import com.ssafy.wanderway.domain.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * 내 정보를 확인하기 위해 사용되는 DTO
 * author 류진호
 */

@Getter
@ToString
@NoArgsConstructor
public class HotPlaceCommentDto {
  private String nickname;
  private Date createDate;
  private String content; 
  private String profileImg = "/imgSrc.jpg";

  public HotPlaceCommentDto(Reply reply){

    if (reply.getMember() != null)
      this.nickname = reply.getMember().getNickname();
    else
      this.nickname = "탈퇴한 회원";

    this.createDate = reply.getDate();
    this.content = reply.getContent();
    if (reply.getMember() != null)
      this.profileImg = reply.getMember().getProfile();
    else
      this.profileImg = "/defaultimg.jpg";
  }
}
