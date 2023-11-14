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

    public List<Hotplace> getAllHotplaces() {
        return hotplaceRepository.findAll();
    }
    public Page<Hotplace> getHotplacesPaged(Pageable pageable) {
        return hotplaceRepository.findAll(pageable);
    }
    public Hotplace getArticleById(long id) {
        return hotplaceRepository.findById(id).orElse(null);
    }
    public void writeArticle(HotplaceDto hotplacedto){
        Hotplace hotplace = new Hotplace();
        //
        // ...
        //


        //hotplaceRepository.save();
        System.out.println(hotplacedto);
    }

}