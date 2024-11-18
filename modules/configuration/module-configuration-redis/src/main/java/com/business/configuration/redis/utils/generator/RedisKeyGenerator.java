package com.business.configuration.redis.utils.generator;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import com.business.configuration.framework.utils.StringToolkits;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Nullable;

/**
 * <b> RedisKeyGenerator </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-18
 */
@UtilityClass
public class RedisKeyGenerator {

    private static final String DELIMITER = "_";

    private static enum RedisBusinessType {

        READ
        , CACHE
        , LOCK

    }



    /**
     * 업무 타입에 따라 키를 생성합니다.
     *
     * @param prefix 업무 타입
     * @param keys 추가 키 요소들
     * @return 생성된 Redis 키
     */
    public static String generateKey(String prefix
            , String... keys) {

        if (StringToolkits.isBlank(prefix)) {
            throw CoreExceptionHandler.handleBusinessException(BasicErrorCode.RESOURCE_NOT_FOUND);
        }

        return generateKeyWithPrefix(prefix, keys);
    }

    /**
     * READ 타입의 Redis 키를 생성합니다.
     *
     * @param keys 키의 추가 요소들 (가변 인자)
     * @return 생성된 READ 타입 Redis 키
     *
     * 예: generateReadKey("user", "123") -> "READ_user_123"
     */
    public static String generateReadKey(String... keys) {
        return generateKeyWithPrefix(RedisBusinessType.READ.name(), keys);
    }

    /**
     * CACHE 타입의 Redis 키를 생성합니다.
     *
     * @param keys 키의 추가 요소들 (가변 인자)
     * @return 생성된 CACHE 타입 Redis 키
     *
     * 예: generateCacheKey("session", "token") -> "CACHE_session_token"
     */
    public static String generateCacheKey(String... keys) {
        return generateKeyWithPrefix(RedisBusinessType.CACHE.name(), keys);
    }

    /**
     * LOCK 타입의 Redis 키를 생성합니다.
     *
     * @param keys 키의 추가 요소들 (가변 인자)
     * @return 생성된 LOCK 타입 Redis 키
     *
     * 예: generateLockKey("resource", "456") -> "LOCK_resource_456"
     */
    public static String generateLockKey(String... keys) {
        return generateKeyWithPrefix(RedisBusinessType.LOCK.name(), keys);
    }

    /**
     * Prefix를 포함한 Redis 키 생성
     *
     * @param prefix 키의 접두사 (업무 타입)
     * @param keys   추가 키 요소들
     * @return 생성된 Redis 키
     */
    @Nullable
    private static String generateKeyWithPrefix(String prefix
            , String[] keys) {

        if (keys == null || keys.length == 0) {
            return prefix;
        }

        String joinedKeys = StringToolkits.join(keys, DELIMITER);
        return String.format("%s%s%s", prefix, DELIMITER, joinedKeys);
    }
}
