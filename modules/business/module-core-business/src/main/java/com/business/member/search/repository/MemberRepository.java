package com.business.member.search.repository;

import com.business.member.search.repository.jpa.MemberJpaRepository;
import com.business.member.search.repository.query.MemberQueryRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


/**
 * <b> MemberRepository </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-19
 */

@Primary
@Repository
public interface MemberRepository
        extends MemberJpaRepository, MemberQueryRepository {

}
