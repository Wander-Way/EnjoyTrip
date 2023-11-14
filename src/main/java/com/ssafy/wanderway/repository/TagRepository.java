package com.ssafy.wanderway.repository;

import com.ssafy.wanderway.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findByText(String text);
}
