package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.domain.Address;
import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.domain.RouteDetail;
import com.ssafy.wanderway.dto.RouteDetailDto;
import com.ssafy.wanderway.dto.RouteDto;
import com.ssafy.wanderway.dto.SearchDto;
import com.ssafy.wanderway.dto.SearchResultDto;
import com.ssafy.wanderway.repository.MemberRepository;
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

/** 공개되어있는 Plan, 즉 Route에 대한 검색을 주관하는 컨트롤러
 * @author 최서현
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final PlanService planService;
    private final RouteService routeService;
    private final MemberRepository memberRepository;

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
        //==임시 로그인유저 코드블럭
        Member member = memberRepository.findById(3L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        //==

        List<RouteDto> routeDtos = routeService.getRouteRecent6(member);
        return new ResponseEntity<>(routeDtos, HttpStatus.OK);
    }

    /** 여행루트 통합검색
     * @param keyword
     * @return
     */
    @PostMapping("")
    public ResponseEntity<SearchResultDto> searchRoute(@RequestBody SearchDto searchDto){
        //==임시 로그인유저 코드블럭
        Member member = memberRepository.findById(3L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        //==

        SearchResultDto searchResult = routeService.searchRoute(searchDto, member);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }

    /** 여행루트 상세조회
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<RouteDetailDto> getDetailRoute(@PathVariable(name = "id") Long id){
        //==임시 로그인유저 코드블럭
        Member member = memberRepository.findById(3L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        //==

        RouteDetailDto routeDetailDto = routeService.getDetailRouteById(id,member);
        return new ResponseEntity<>(routeDetailDto, HttpStatus.OK);
    }

    /** 여행플랜 좋아요
     * @param id
     * @return
     */
    @PostMapping("/{id}/like")
    public ResponseEntity<Void> likeRoute(@PathVariable(name = "id") Long id){
        //==임시 로그인유저 코드블럭
        Member member = memberRepository.findById(3L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        //==
        routeService.likeRoute(id, member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /** 여행플랜 좋아요 취소
     * @param id
     * @return
     */
    @DeleteMapping("/{id}/like")
    public ResponseEntity<Void> dislikeRoute(@PathVariable(name = "id") Long id){
        //==임시 로그인유저 코드블럭
        Member member = memberRepository.findById(3L).orElse((null));
        if(member == null) throw new NullPointerException("존재하지 않는 Member입니다");
        //==
        routeService.cencelLikeRoute(id, member);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
