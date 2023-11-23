package com.ssafy.wanderway.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
@NoArgsConstructor
public class SearchResultDto {
    private Long totalCnt;
    private List<RouteDto> routes;

    @Builder
    public SearchResultDto(Long totalCnt, List<RouteDto> dtos){
        this.totalCnt = totalCnt;
        this.routes = dtos;
    }
}
