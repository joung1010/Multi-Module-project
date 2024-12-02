package com.business.member.redis.service;

import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * <b> MemberRedisSearchService </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-12-02
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberRedisSearchService {
    public static final String REDIS_TIME_LIMIT_KEY = "member_redis_time_limit";
    public static final String REDIS_CIRCUIT_BREAKER_KEY = "member_redis_circuit_breaker";

    private final MemberRedisInfoQueryService queryService;
    private final MemberRedisInfoLoadService loadService;

    @TimeLimiter(name = REDIS_TIME_LIMIT_KEY)
    @CircuitBreaker(name = REDIS_CIRCUIT_BREAKER_KEY, fallbackMethod = "fallbackFindMemberInfoById")
    public CompletableFuture<MemberRedisInfoEntity> findMemberInfoById(final Long id) {

        return CompletableFuture.supplyAsync(() -> queryService.findById(id));
    }

    public CompletableFuture<MemberRedisInfoEntity> fallbackFindMemberInfoById(final Long id, final Throwable e) {

        return CompletableFuture.supplyAsync(() -> loadService.load(id));
    }
}
