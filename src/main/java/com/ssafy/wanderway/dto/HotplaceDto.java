package com.ssafy.wanderway.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
@ApiModel(value   = "HotplaceDtp : 핫플레이스 게시글 정보")
public class HotplaceDto {
    private Long id;
    private String city;
    private String detailAddress;
    private String district;
    private float latitude;
    private float longitude;
    private String name;
    private String town;
    private String content;
    private long hit;
    private String title;
}
