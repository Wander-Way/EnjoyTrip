package com.ssafy.wanderway.repository;


import com.ssafy.wanderway.domain.Hotplace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotplaceRepository extends JpaRepository<Hotplace, Long> {
    // 추가적인 쿼리 메서드가 필요하면 여기에 정의
}