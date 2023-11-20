package com.ssafy.wanderway.repository;

import com.ssafy.wanderway.domain.Member;
import com.ssafy.wanderway.dto.PlanDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

}
