package com.business.domain.repository;

import com.business.domain.TMemberAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-07-22
 */
public interface MemberAddressJpaRepository extends JpaRepository<TMemberAddressEntity,Long> {
    List<TMemberAddressEntity> findByMemberId(Long memberId);
}
