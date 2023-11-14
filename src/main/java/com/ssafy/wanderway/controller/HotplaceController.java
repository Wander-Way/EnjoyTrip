package com.ssafy.wanderway.controller;


import com.ssafy.wanderway.domain.Hotplace;
import com.ssafy.wanderway.dto.HotplaceDto;
import com.ssafy.wanderway.repository.HotplaceRepository;
import com.ssafy.wanderway.service.HotplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/hotplace")
@Api("핫플레이스 게시판 컨트롤러")
public class HotplaceController {

    //private static final Logger logger = LoggerFactory.getLogger(HotPlaceBoardController.class);
    public HotplaceController(){

    }
    @Autowired
    private HotplaceService hotplaceService;
    @Autowired
    private HotplaceRepository hotplaceRepository;

    /*@GetMapping("/board")
    public List<Hotplace> getAllHotplaces() {
        return hotplaceRepository.findAll();
    }*/

    @ApiOperation(value = "핫플레이스 보드 메인화면", notes = "지역 선택하는 페이지")
    @GetMapping
    public ResponseEntity<String> Test(){
        try {
            //BoardListDto boardListDto = boardService.listArticle(map);
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
            return ResponseEntity.ok().headers(header).body("hello");//boardListDto);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }





    @GetMapping("/board")
    public List<Hotplace> getHotplacesPaged(
            @RequestParam(name = "pgno", defaultValue = "1") int pageNumber,
            @RequestParam(name = "spp", defaultValue = "20") int itemsPerPage
    ) {
        Pageable pageable = PageRequest.of(pageNumber - 1, itemsPerPage);

        /*System.out.println("==페이징 안하고 실행==");
        for(Hotplace h : hotplaceService.getAllHotplaces()){
            System.out.println(h);
        }
        System.out.println("=페이징 하고 실행==");
        for(Hotplace h : hotplaceService.getHotplacesPaged(pageable).getContent()){
            System.out.println(h);
        }*/
        return hotplaceService.getHotplacesPaged(pageable).getContent();
    }


    @GetMapping("/board/{articleno}")
    public ResponseEntity<Hotplace> getArticleContent(@PathVariable Long articleno) {
        Hotplace articleContent = hotplaceService.getArticleById(articleno);

        if (articleContent != null) {
            return ResponseEntity.ok(articleContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("board")
    public ResponseEntity<?> writeArticle(@RequestBody HotplaceDto hotplaceDto){
        System.out.println("writeArticle in");
        try {
            hotplaceService.writeArticle(hotplaceDto);
            //boardService.writeArticle(boardDto);
//			return ResponseEntity.ok().build();
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }


    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
