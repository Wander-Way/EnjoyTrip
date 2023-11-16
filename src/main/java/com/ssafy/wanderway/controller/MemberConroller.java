package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.dto.MemberDto;
import com.ssafy.wanderway.dto.MyInfoRequestDto;
import com.ssafy.wanderway.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("회원 관리 컨트롤러")
public class MemberConroller {
  @Autowired
  private MemberService memberService;


  /*
  //로그인 차후 구현
  @PostMapping("/login")
  @ApiOperation("로그인")
  public ResponseEntity<MemberDto> login(@RequestBody MemberDto memberDto) {
    System.out.println(memberDto);
    try {
      MemberDto loginMember = memberService.login(memberDto);
      return new ResponseEntity<MemberDto>(loginMember, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<MemberDto>(HttpStatus.BAD_REQUEST);
    }
  } 
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
  /*
  @PostMapping("/mypage/planlist")
  @ApiOperation("내 여행 계획을 가져옵니다.")
  public ResponseEntity<> mypagePlanList(@RequestBody MyInfoRequestDto myInfoRequestDto) {
    System.out.println(myInfoRequestDto);
    try {



      //memberService.mypagePlanList(myInfoRequestDto);
      return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
    }
  }
*/



  @PostMapping("/signup2")
  public ResponseEntity<String> signup2(@RequestBody MemberDto memberDto) {
    System.out.println(memberDto);
    return null;
  }


}
