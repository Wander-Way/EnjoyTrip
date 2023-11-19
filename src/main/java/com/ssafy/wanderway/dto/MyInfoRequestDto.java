package com.ssafy.wanderway.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

/**
 * 
 * 내 정보를 확인하기 위해 사용되는 DTO
 * author 류진호
 */
@Getter @ToString
@NoArgsConstructor
public class MyInfoRequestDto {
    private String email;
    private String password;

}
