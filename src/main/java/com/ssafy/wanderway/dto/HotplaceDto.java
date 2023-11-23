package com.ssafy.wanderway.dto;

import com.ssafy.wanderway.domain.Hotplace;
import com.ssafy.wanderway.domain.Reply;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter @ToString
@NoArgsConstructor
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
    private Date date;//작성일

    private List<HotPlaceCommentDto> hotPlaceCommentDtoList = new ArrayList<>();

    public HotplaceDto(Hotplace hot){
        this.id = hot.getId();
        if (hot.getMember() != null)
            this.authorName = hot.getMember().getNickname();
        this.city = hot.getAddress().getCity();
        this.detailAddress = hot.getAddress().getDetailAddress();
        this.district = hot.getAddress().getDistrict();
        if (hot.getAddress().getLatitude() != null)
            this.latitude = hot.getAddress().getLatitude();
        else
            this.latitude = 0;
        if (hot.getAddress().getLongitude() != null)
            this.longitude = hot.getAddress().getLongitude();
        else
            this.longitude = 0;

        this.name = hot.getAddress().getName();
        this.town = hot.getAddress().getTown();
        this.content = hot.getContent();
        if (hot.getHit() != null)
            this.hit = hot.getHit();
        else
            this.hit = 0;
        //this.hit = hot.getHit();
        this.title = hot.getTitle();
        //this.date = hot.get
        for(Reply reply : hot.getReplies()){
            this.hotPlaceCommentDtoList.add(new HotPlaceCommentDto(reply));
        }
    }
}
