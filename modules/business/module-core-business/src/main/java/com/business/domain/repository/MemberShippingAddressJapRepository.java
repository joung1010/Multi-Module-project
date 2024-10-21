package com.business.domain.repository;

import com.business.domain.TShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <b> MemberShippingAddressJapRepository </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-05
 */
public interface MemberShippingAddressJapRepository extends JpaRepository<TShippingAddress, Long> {
    List<TShippingAddress> findByMemberAddressId(Long addressId);
}
