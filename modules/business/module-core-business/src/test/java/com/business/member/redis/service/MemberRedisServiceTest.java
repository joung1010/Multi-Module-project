package com.business.member.redis.service;

import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> MemberRedisServiceTest </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-12-02
 */

@Slf4j
@ActiveProfiles("local")
@SpringBootTest
class MemberRedisServiceTest {

    @Autowired
    private MemberRedisInfoLoadService loadService;

    @Autowired
    private MemberRedisInfoQueryService queryService;

    @Test
    void loadTest() {
        final long memberId = 1L;

        loadService.load(memberId);

    }

    @Test
    void queryTest() {
        final long memberId = 1L;

        MemberRedisInfoEntity info = queryService.findById(memberId);

        assertNotNull(info);
        log.info(info.toString());
    }

}