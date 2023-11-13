package com.ssafy.wanderway.repository;

import com.ssafy.wanderway.domain.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {


}
