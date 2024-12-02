package com.business.member.redis.service;

import com.business.configuration.redis.exception.RedisNotFoundException;
import com.business.configuration.redis.utils.generator.RedisKeyGenerator;
import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import com.business.member.redis.repository.MemberRedisInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * <b> MemberRedisInfoQueryService </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberRedisInfoQueryService {

    private final MemberRedisInfoRepository repository;

    public MemberRedisInfoEntity findById(Long id) {
        log.info("Redis 회원 조회 ==> {}", id);

        String redisKey = RedisKeyGenerator.generateKey(MemberRedisInfoEntity.HASH_KEY, String.valueOf(id));
        log.info("Redis 회원 조회 Key ==> {}", redisKey);

        return repository.findById(redisKey)
                .orElseThrow(RedisNotFoundException::new);
    }
}
