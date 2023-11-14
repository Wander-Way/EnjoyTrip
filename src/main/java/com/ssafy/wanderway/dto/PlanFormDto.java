package com.ssafy.wanderway.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

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
