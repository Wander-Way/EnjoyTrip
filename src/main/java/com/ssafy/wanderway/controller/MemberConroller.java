package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.dto.MemberDto;
import com.ssafy.wanderway.dto.MyInfoRequestDto;
import com.ssafy.wanderway.dto.PlanDto;
import com.ssafy.wanderway.dto.RouteDto;
import com.ssafy.wanderway.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("*")
@RequestMapping("/user")
@Api("회원 관리 컨트롤러")
public class MemberConroller {
  @Autowired
  private MemberService memberService;


  //임시 로그인
  @PostMapping("/login")
  @ApiOperation("로그인")
  public ResponseEntity<?> login(@RequestBody MyInfoRequestDto myinforequestdto) {
    System.out.println(myinforequestdto);
    try {
      MemberDto loginMember = memberService.login(myinforequestdto);
      if(loginMember == null)
        return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
      else
        return new ResponseEntity<MemberDto>(loginMember, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("ERROR",HttpStatus.BAD_REQUEST);
    }
  } 


  /**
   * 회원가입
   *
   * @param memberDto
   * @return
   */
  @PostMapping("/signup")
  @ApiOperation("회원가입")
  public ResponseEntity<String> signup(@RequestBody MemberDto memberDto) {
    System.out.println(memberDto);
    try {
      memberService.signup(memberDto);
      return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
    }
  }






  /**
   * 내 정보 조회
   *
   * @param myInfoRequestDto
   * @return
   */
  @PostMapping("/mypage")
  @ApiOperation("회원정보 조회")
  public ResponseEntity<MemberDto> mypage(@RequestBody MyInfoRequestDto myInfoRequestDto) {
    System.out.println(myInfoRequestDto);
    try {
      MemberDto memberDtoResult = memberService.mypage(myInfoRequestDto);
      return new ResponseEntity<MemberDto>(memberDtoResult, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<MemberDto>(HttpStatus.BAD_REQUEST);
    }
  } 

  /**
   * 내 정보 수정
   *
   * @param memberDto
   * @return
   */
  @PutMapping("/mypage/edit")
  @ApiOperation("회원정보 수정")
  public ResponseEntity <String> mypageEdit(@RequestBody MemberDto memberDto) {
    System.out.println(memberDto);
    try {
      memberService.mypageEdit(memberDto);
      return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
    }
  }


  /**
   *
   * 내 여행 계획을 가져옵니다.
   *
   * @param myInfoRequestDto
   * @return
   *
   */

  @PostMapping("/mypage/planlist")
  @ApiOperation("내 여행 계획을 가져옵니다.")
  public ResponseEntity<?> mypagePlanList(@RequestBody MyInfoRequestDto myInfoRequestDto) {
    //System.out.println(myInfoRequestDto);
    try {
      List<RouteDto> result = memberService.mypagePlanList(myInfoRequestDto);
      return new ResponseEntity<List<RouteDto>>(result, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
    }
  }


  /**
   * 내가 좋아요한 계획들을 가져옵니다
   * @param myInfoRequestDto
   */
  @PostMapping("/mypage/likelist")
  @ApiOperation("내가 좋아요한 계획들을 가져옵니다")
  public ResponseEntity<?> mypageLikeList(@RequestBody MyInfoRequestDto myInfoRequestDto) {
    //System.out.println(myInfoRequestDto);
    try {
      List<RouteDto> result = memberService.mypageLikeList(myInfoRequestDto);
      return new ResponseEntity<List<RouteDto>>(result, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/mypage/findpw")
  public ResponseEntity<String> findPw(@RequestBody String email) {
    System.out.println(email);
    try {
      MemberDto memberDto = memberService.findPw(email);
      if (memberDto != null)
        return new ResponseEntity<String>(memberDto.getPassword(), HttpStatus.OK);
      else
        return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("Failed", HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/signup2")
  public ResponseEntity<String> signup2(@RequestBody MemberDto memberDto) {
    System.out.println(memberDto);
    return null;
  }


}
