package com.ssafy.wanderway.repository;


import com.ssafy.wanderway.domain.Hotplace;
import com.ssafy.wanderway.domain.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotplaceRepository extends JpaRepository<Hotplace, Long> {
    // 추가적인 쿼리 메서드가 필요하면 여기에 정의

    @Query("SELECT hp FROM Hotplace hp WHERE hp.address.city LIKE %?1%")
    Page<Hotplace> findByHotplaceWithCity(String city, Pageable pageable);
}