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
    @ApiModelProperty(value = "글번호")
    private Long id;

    @ApiModelProperty(value = "도시")
    private String city;
    @ApiModelProperty(value = "도시")
    private String detailAddress;

    @ApiModelProperty(value = "도시")
    private String dostroct;

    @ApiModelProperty(value = "도시")
    private float latitude;

    @ApiModelProperty(value = "도시")
    private float longitude;
    @ApiModelProperty(value = "도시")
    private String name;
    @ApiModelProperty(value = "도시")
    private String town;
    @ApiModelProperty(value = "도시")
    private String content;
    @ApiModelProperty(value = "도시")
    private long hit;
    @ApiModelProperty(value = "도시")
    private String title;
}
