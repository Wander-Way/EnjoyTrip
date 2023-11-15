package com.ssafy.wanderway.dto;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter @ToString
public class SearchDto {
    private int page;
    private List<String> tags;
    private List<Integer> periods;
}
