package com.ssafy.wanderway.dto;


import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.domain.Route;
import com.ssafy.wanderway.domain.TagToPlan;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.ssafy.wanderway.service.PlanService.routesToLocationDtos;

/** 여행루트를 상세조회할때 필요한 DTO
 * @author 최서현
 */
@Getter @ToString
public class RouteDetailDto {

    private Long planId;
    private String nickName;
    private String profile;

    private String title;
    private String location;
    private int period;
    private String thumbnail;
    private String description;
    private List<String> tag;
    private int like_cnt;
    private boolean is_like;
    private Map<Integer, List<LocationDto>> plan;

    @Builder
    public RouteDetailDto(Plan plan, boolean is_like){
        this.title = plan.getTitle();
        this.planId = plan.getId();
        this.nickName = plan.getMember().getNickname();
        this.profile = plan.getMember().getProfile();

        this.location = plan.getLocation().getName();
        this.period = plan.getRoutes().get(plan.getRoutes().size()-1).getDay();
        this.thumbnail = plan.getThumbnail();
        this.description = plan.getDescription();
        this.tag = new ArrayList<>();
        for(TagToPlan ttp : plan.getTags()) this.tag.add(ttp.getTag().getText());
        this.like_cnt = plan.getLikes().size();
        this.is_like = is_like;
        this.plan = routesToLocationDtos (plan.getRoutes());
    }

}
