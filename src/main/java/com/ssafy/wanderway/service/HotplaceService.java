package com.ssafy.wanderway.service;

import com.ssafy.wanderway.domain.Hotplace;
import com.ssafy.wanderway.dto.HotplaceDto;
import com.ssafy.wanderway.repository.HotplaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
}