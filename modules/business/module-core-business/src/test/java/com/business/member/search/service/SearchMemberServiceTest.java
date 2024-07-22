package com.business.member.search.service;

import com.business.domain.TMemberAddressEntity;
import com.business.domain.TMemberEntity;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.repository.jpa.MemberAddressJpaRepository;
import com.business.member.search.repository.jpa.MemberJpaRepository;
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
    private MemberJpaRepository searchRepository;

    @Autowired
    private MemberAddressJpaRepository memberAddressJpaRepository;

    @Test
    @DisplayName("member Search By Id")
    void memberSearchById() {
       Long id = 1L;

        TMemberEntity tMember = searchRepository.findById(id)
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

        TMemberEntity byEmailAndPassword = searchRepository.findByEmailAndPassword(memberCondDto);
        assertNotNull(byEmailAndPassword);

        assertEquals(memberCondDto.getEmail(), byEmailAndPassword.getEmail());
    }

    @Test
    void oneToManyTestByAddress() {
        Long id = 1L;

        TMemberEntity tMember = searchRepository.findById(id)
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
}