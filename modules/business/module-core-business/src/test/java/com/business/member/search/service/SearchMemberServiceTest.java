package com.business.member.search.service;

import com.business.domain.TMemberAddressEntity;
import com.business.domain.TMemberEntity;
import com.business.domain.TShippingAddress;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.repository.jpa.MemberAddressJpaRepository;
import com.business.member.search.repository.jpa.MemberJpaRepository;
import com.business.member.search.repository.jpa.MemberShippingAddressJapRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-07-17
 */
@Slf4j
@ActiveProfiles("local")
@SpringBootTest
class SearchMemberServiceTest {
    @Autowired
    private MemberJpaRepository memberJpaRepository;

    @Autowired
    private MemberAddressJpaRepository memberAddressJpaRepository;

    @Autowired
    private MemberShippingAddressJapRepository memberShippingAddressJapRepository;

    @Test
    @DisplayName("member Search By Id")
    void memberSearchById() {
       Long id = 1L;

        TMemberEntity tMember = memberJpaRepository.findById(id)
                .orElse(null);
        assertNotNull(tMember);

        assertEquals(id, tMember.getId());

    }

    @Test
    void memberSearchByEmailAndPassword() {
        MemberCondDto memberCondDto = MemberCondDto.builder()
                .email("john.doe@example.com")
                .password("password123")
                .build();

        TMemberEntity byEmailAndPassword = memberJpaRepository.findByEmailAndPassword(memberCondDto);
        assertNotNull(byEmailAndPassword);

        assertEquals(memberCondDto.getEmail(), byEmailAndPassword.getEmail());
    }

    @Test
    void oneToManyTestByAddress() {
        Long id = 1L;

        TMemberEntity tMember = memberJpaRepository.findById(id)
                .orElse(null);
        assertNotNull(tMember);

        List<TMemberAddressEntity> memberAdressList = memberAddressJpaRepository.findByMemberId(tMember.getId());
        assertFalse(memberAdressList.isEmpty(), "address is Empty");

        memberAdressList.forEach(address -> {
            assertNotNull(address.getAddress());
            assertNotNull(address.getCity());
            assertNotNull(address.getZipcode());
            log.info("member addr: {} {} {} {}",address.getAddress(),address.getCity(),address.getState(),address.getZipcode());
        });

    }

    @Test
    void selectShippingAddressTest() {
        MemberCondDto condDto = MemberCondDto.builder()
                .id(1L)
                .build();

        List<TMemberAddressEntity> memberAddr = memberAddressJpaRepository.findByMemberId(condDto.getId());
        TMemberAddressEntity memberAddress = memberAddr.stream()
                .findFirst()
                .orElse(null);
        assertNotNull(memberAddress);

        List<TShippingAddress> shippingAddresses = memberShippingAddressJapRepository.findByMemberAddressId(memberAddress.getId());
        shippingAddresses.forEach(addr -> {
            assertEquals(memberAddress.getId(),addr.getId());
            assertNotNull(addr.getShippingAddress());
            assertNotNull(addr.getShippingCity());
            assertNotNull(addr.getShippingState());
        });
    }
}