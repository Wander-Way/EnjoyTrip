package com.ssafy.wanderway.repository;


import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.ssafy.wanderway.domain.Plan;
import com.ssafy.wanderway.domain.QPlan;
import com.ssafy.wanderway.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class SearchRepository {
    private final EntityManager entityManager;

    public Map<String, Object> searchPlan(SearchDto searchDto, Pageable pageable){
        QPlan qplan = QPlan.plan;
        BooleanBuilder builder = new BooleanBuilder();

        //태그 기준으로 검색
        if(searchDto.getTags() != null && !searchDto.getTags().isEmpty()){
            BooleanExpression tagExpression = qplan.tags.any().tag.text.in(searchDto.getTags());
            builder.and(tagExpression);
        }

        //기간 기준으로 검색
        if(searchDto.getPeriods() != null && !searchDto.getPeriods().isEmpty()){
            BooleanExpression periodExpression = qplan.period.in(searchDto.getPeriods());
            builder.and(periodExpression);
        }

        JPAQuery<Plan> query = new JPAQuery<>(entityManager);
        List<Plan> content = query.from(qplan)
                                    .where(builder)
                                    .offset(pageable.getOffset())
                                    .limit(pageable.getPageSize())
                                    .fetch();

        Long total = query.from(qplan)
                .where(builder)
                .select(qplan.id.countDistinct())
                .fetchOne();
        long totalCount = (total != null) ? total : 0;

        Map<String, Object> result = new HashMap<>();
        result.put("content", content);
        result.put("total", totalCount);

        return result;
    }

}
