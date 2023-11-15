package com.ssafy.wanderway.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/** 새로운 플랜 정보를 저장하기 위한 DTO
 * @author 최서현
 */
@Getter @ToString
@NoArgsConstructor
public class PlanFormDto {
    private LocationDto location;
    private String title;
    private String description;
    private MultipartFile file;
    private List<String> tags;
    private Map<Integer, List<LocationDto>> plan;
}
