package com.ssafy.wanderway.repository;



import com.ssafy.wanderway.domain.Plan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    @Query("SELECT p FROM Plan p WHERE p.location.city LIKE %?1%")
    Page<Plan> findByLocationCityContaining(String city, Pageable pageable);
}
