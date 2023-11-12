package com.ssafy.wanderway.controller;

import com.ssafy.wanderway.domain.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/route")
public class RouteController {


    @PutMapping("/{id}")
    public ResponseEntity sharePlan(@PathVariable(name = "id") Long id){
        return null;
    }

    @GetMapping("")
    public ResponseEntity getRoute(){
        return null;
    }

    @PostMapping("")
    public ResponseEntity searchRoute(@RequestBody String keyword){
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity getDetailRoute(@PathVariable(name = "id") Long id){
        return null;
    }

    @PostMapping("/{id}/like")
    public ResponseEntity likeRoute(@PathVariable(name = "id") Long id){
        return null;
    }
}
