package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.domain.Address;
import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.dto.RouteDto;
import com.ssafy.wanderway.repository.PlanRepository;
import com.ssafy.wanderway.service.PlanService;
import com.ssafy.wanderway.service.RouteService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final PlanService planService;
    private final RouteService routeService;

    /** 루트 공개여부 변경
     * @param id
     * @returnm HTTPSTATUS
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> sharePlan(@PathVariable(name = "id") Long id){
        planService.modifyIspublic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** 여행루트 조회 디폴트 데이터 : 최신 데이터 3개를 불러옵니다.
     * @return List<RouteDto>
     */
    @GetMapping("")
    public ResponseEntity<List<RouteDto>> getRoute(){
        List<RouteDto> routeDtos = routeService.getRouteRecent3();
        return new ResponseEntity<>(routeDtos, HttpStatus.OK);
    }

    /** 여행루트 통합검색
     * @param keyword
     * @return
     */
    @PostMapping("")
    public ResponseEntity searchRoute(@RequestBody String keyword){
        return null;
    }

    /** 여행루트 상세조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity getDetailRoute(@PathVariable(name = "id") Long id){
        return null;
    }

    /** 여행플랜 좋아요
     * @param id
     * @return
     */
    @PostMapping("/{id}/like")
    public ResponseEntity likeRoute(@PathVariable(name = "id") Long id){
        return null;
    }
}
