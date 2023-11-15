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


    /**
     *  핫플레이스 게시글의 전체 목록을 조회합니다
     * @return 조회된 게시글의 목록
     */
    /*@GetMapping("/boardAll")
    public List<Hotplace> getAllHotplaces() {
        return hotplaceRepository.findAll();
    }*/



    /**
     *  테스트 함수
     * @return "HELLO!"
     */
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




    /**
     *  핫플레이스 게시글을 페이징 처리하여 조회합니다
     * @param pageNumber 조회할 페이지
     * @param itemsPerPage 페이지 당 조회할 게시글 수
     */
    @GetMapping("/board")
    public List<Hotplace> getHotplacesPaged(
            @RequestParam(name = "pgno", defaultValue = "1") int pageNumber,
            @RequestParam(name = "spp", defaultValue = "20") int itemsPerPage
    ) {
        Pageable pageable = PageRequest.of(pageNumber - 1, itemsPerPage);
        return hotplaceService.getHotplacesPaged(pageable).getContent();
    }


    /**     
     *  핫플레이스 게시글을 상세조회합니다
     * @param articleno 조회할 게시글의 번호
     */
    @GetMapping("/board/{articleno}")
    public ResponseEntity<Hotplace> getArticleContent(@PathVariable Long articleno) {
        Hotplace articleContent = hotplaceService.getArticleById(articleno);

        if (articleContent != null) {
            return ResponseEntity.ok(articleContent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /** *  핫플레이스 게시글을 작성합니다
     * @param hotplaceDto 게시글을 위한 정보를 담고있는 DTO
     */
    @PostMapping("board")
    public ResponseEntity<?> writeArticle(@RequestBody HotplaceDto hotplaceDto){
        System.out.println("writeArticle in");
        try {
            hotplaceService.writeArticle(hotplaceDto);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    /**
    *  핫플레이스 게시글을 수정합니다
     * @param hotplaceDto 수정할 게시글의 정보를 담은 DTO
     */
    @PutMapping("board")
    public ResponseEntity<?> updateArticle(@RequestBody HotplaceDto hotplaceDto){
        try {
            hotplaceService.updateArticle(hotplaceDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }   


    /** 
     *  핫플레이스 게시글을 삭제합니다
     * @param articleno 삭제할 게시글의 번호
     * */
    @DeleteMapping("board/{articleno}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleno){
        try {
            hotplaceService.deleteArticle(articleno);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }


    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
