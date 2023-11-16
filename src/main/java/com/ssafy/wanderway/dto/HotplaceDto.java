package com.ssafy.wanderway.dto;

import com.ssafy.wanderway.domain.Hotplace;
import com.ssafy.wanderway.domain.Reply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Data
@ApiModel(value   = "HotplaceDtp : 핫플레이스 게시글 정보")
public class HotplaceDto {
    private Long id;
    private String authorName;
    private String city;
    private String detailAddress;
    private String district;
    private float latitude;
    private float longitude;
    private String name;//장소명
    private String town;
    private String content;
    private long hit;
    private String title;

    private List<HotPlaceCommentDto> hotPlaceCommentDtoList;

    public HotplaceDto(Hotplace hot){
        this.id = hot.getId();
        this.authorName = hot.getMember().getNickname();
        this.city = hot.getAddress().getCity();
        this.detailAddress = hot.getAddress().getDetailAddress();
        this.district = hot.getAddress().getDistrict();
        this.latitude = hot.getAddress().getLatitude();
        this.longitude = hot.getAddress().getLongitude();
        this.name = hot.getAddress().getName();
        this.town = hot.getAddress().getTown();
        this.content = hot.getContent();
        this.hit = hot.getHit();
        this.title = hot.getTitle();
        for(Reply reply : hot.getReplies()){
            this.hotPlaceCommentDtoList.add(new HotPlaceCommentDto(reply));
        }
    }
}
