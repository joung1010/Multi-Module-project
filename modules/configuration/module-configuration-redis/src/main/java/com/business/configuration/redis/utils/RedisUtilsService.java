package com.business.configuration.redis.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <b> RedisUtilsService </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-11
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisUtilsService {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * Redis에 데이터를 저장합니다.
     * @param key 저장할 키
     * @param value 저장할 값
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * Redis에 데이터를 저장하고 만료 시간을 설정합니다.
     * @param key 저장할 키
     * @param value 저장할 값
     * @param timeout 만료 시간
     * @param unit 만료 시간 단위
     */
    public void setWithExpire(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * Redis에서 데이터를 조회합니다.
     * @param key 조회할 키
     * @return 키에 해당하는 값
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * Redis에서 데이터를 삭제합니다.
     * @param key 삭제할 키
     * @return 삭제 성공 여부
     */
    public boolean delete(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * Redis에 키가 존재하는지 확인합니다.
     * @param key 확인할 키
     * @return 키 존재 여부
     */
    public boolean hasKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    /**
     * Redis 키에 만료 시간을 설정합니다.
     * @param key 만료 시간을 설정할 키
     * @param timeout 만료 시간
     * @param unit 시간 단위
     * @return 설정 성공 여부
     */
    public boolean expire(String key, long timeout, TimeUnit unit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }

}
