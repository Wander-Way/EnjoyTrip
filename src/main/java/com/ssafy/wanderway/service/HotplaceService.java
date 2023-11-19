package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.Hotplace;
import com.ssafy.wanderway.domain.Reply;
import com.ssafy.wanderway.dto.HotPlaceCommentDto;
import com.ssafy.wanderway.dto.HotplaceDto;
import com.ssafy.wanderway.repository.HotplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 *  * 핫플레이스 게시판의 비즈니스 로직을 정의한 서비스 클래스입니다
 * 
 * @date 2023.11.13. ~ 2023.11.23.
 * @version 1.0
 * @author 류진호
 */
@Service
@Transactional
public class HotplaceService {

    @Autowired
    private HotplaceRepository hotplaceRepository;

    /**
     * 
     * 핫플레이스 게시글의 전체 목록을 조회합니다
     * @return 조회된 게시글의 목록
     */
    public List<Hotplace> getAllHotplaces() {
        return hotplaceRepository.findAll();
    }

    /**
     * 
     * 핫플레이스 게시글을 페이징 처리하여 조회합니다
     * @param pageable 페이징 처리를 위한 정보
     * @return 조회된 게시글의 정보
     */
    public Page<Hotplace> getHotplacesPaged(Pageable pageable) {
        return hotplaceRepository.findAll(pageable);
    }
    public Page<Hotplace> getHotplacePagedWithPlace(Pageable pageable, String place){
        //System.out.println(place);
        return hotplaceRepository.findByHotplaceWithCity(place, pageable);
    }


    /**
     * 
     * 핫플레이스 게시글을 조회합니다
     * @param id 게시글의 고유 ID
     * @return 조회된 게시글의 정보
     */
    public Hotplace getArticleById(long id) {
        Hotplace hotplace = hotplaceRepository.findById(id).orElse(null);
        if (hotplace != null)
            hotplace.increaseHit();
        return hotplace;
    }


    /**
     * 
     * 핫플레이스 게시글을 작성합니다
     * @param hotplacedto 게시글을 위한 정보를 담고있는 DTO
     */
    public void writeArticle(HotplaceDto hotplacedto){
        Hotplace hotplace = new Hotplace(hotplacedto);
        hotplaceRepository.save(hotplace);
    }
    
    /**
     * 
     * 핫플레이스 게시글을 수정합니다
     * @param hotplacedto 게시글을 위한 정보를 담고있는 DTO
     */
    public void updateArticle(HotplaceDto hotplacedto){
        Hotplace hotplace = new Hotplace(hotplacedto);
        hotplaceRepository.save(hotplace);
    }

    /**     
     * 
     * * 핫플레이스 게시글을 삭제합니다
     * @param id 게시글의 고유 ID
     */
    public void deleteArticle(long id){
        hotplaceRepository.deleteById(id);
    }


    /**
     *  * 핫플레이스 게시글에 댓글을 작성합니다
     * @param articleno 댓글을 작성할 게시글의 번호
     * @param hotplaceCommentDto 댓글을 위한 정보를 담고있는 DTO
     */
    public void writeComment(Long articleno, HotPlaceCommentDto hotplaceCommentDto) {
        Hotplace hotplace = hotplaceRepository.findById(articleno).orElse(null);
        if (hotplace != null) {
            hotplace.addComment(hotplaceCommentDto);
            /*System.out.println("@@@@@@@: "+ hotplace.getReplies().get(0).getContent());
            System.out.println("@@@@@@@: "+ hotplace.getReplies().get(0).getMember().getNickname());
            System.out.println("@@@@@@@: "+ hotplace.getReplies().get(0).getHotplace().getTitle());
            */
            //hotplaceRepository.save(hotplace);
            //System.out.println("댓글 사이즈 : " + hotplace.getReplies().size());
        }
    }

}