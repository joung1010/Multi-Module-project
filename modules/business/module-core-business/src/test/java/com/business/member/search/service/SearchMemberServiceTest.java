package com.business.member.search.service;

import com.business.domain.TMemberEntity;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.repository.jpa.MemberSearchRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
    private MemberSearchRepository searchRepository;

    @Test
    @DisplayName("member Search By Id")
    void memberSearchById() {
       Long id = 1L;

        TMemberEntity tMember = searchRepository.findById(id)
                .orElse(null);
        assertNotNull(tMember);

        assertEquals(id, tMember.getId());

    }
}