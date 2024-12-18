package com.business.domain.repository;

import com.business.configuration.repository.CoreHibernateJpaRepository;
import com.business.domain.TMemberEntity;
import com.business.member.search.model.dto.MemberCondDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-07-16
 */
public interface MemberJpaRepository extends CoreHibernateJpaRepository<TMemberEntity,Long> {

    @Query("SELECT member FROM TMemberEntity member JOIN FETCH member.memberDetails memberDetail WHERE member.email = :#{#cond.email} AND member.password = :#{#cond.password}")
    TMemberEntity findByEmailAndPassword(@Param("cond") MemberCondDto reqDto);
}
