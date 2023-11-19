package com.ssafy.wanderway.dto;


import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.domain.TagToPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/** 모든 여행루트를 조회할때 데이터를 바인딩하는 DTO
 * @author 최서현
 */
@Getter @ToString @NoArgsConstructor
public class RouteDto {

    private Long route_id;
    private String location;
    private String period;
    private String thumbnail;
    private String title;
    private String description;
    private List<String> tag;
    private boolean isLike;
    private int like_cnt;

    @Builder
    public RouteDto(Plan plan, boolean isLike) {
        this.route_id = plan.getId();
        this.location = plan.getLocation().getName();
        this.period = String.valueOf(plan.getRoutes().get(plan.getRoutes().size()-1).getDay());
        this.thumbnail = plan.getThumbnail();
        this.title = plan.getTitle();
        this.description = plan.getDescription();

        this.tag = new ArrayList<>();
        for(TagToPlan ttp : plan.getTags()) tag.add(ttp.getTag().getText());
        this.isLike = isLike;
        this.like_cnt = plan.getLikes().size();
    }

    public RouteDto(Plan plan) {
        this.route_id = plan.getId();
        this.location = plan.getLocation().getName();
        this.period = String.valueOf(plan.getRoutes().get(plan.getRoutes().size()-1).getDay());
        this.thumbnail = plan.getThumbnail();
        this.title = plan.getTitle();
        this.description = plan.getDescription();

        this.tag = new ArrayList<>();
        for(TagToPlan ttp : plan.getTags()) tag.add(ttp.getTag().getText());
        this.like_cnt = plan.getLikes().size();
    }
}
