package com.business.utils;

import com.business.configuration.redis.utils.RedisUtilsService;
import com.business.configuration.redis.utils.generator.RedisKeyGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b> RedisUtilsServiceTest </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-11
 */

@Slf4j
@SpringBootTest
class RedisUtilsServiceTest {

    @Autowired
    private RedisUtilsService redisUtilsService;

    private String key;
    private String value;

    @BeforeEach
    void setUp() {
        key = RedisKeyGenerator.generateKey("TEST", "T0001");

        Random random = new Random();
        int randomValue = random.nextInt(10000) + 1;
        value = String.valueOf(randomValue);
    }

    @Test
    @Disabled
    void set() {

        redisUtilsService.set(key,value);
    }

    @Test
    void get() {
        String actualValue = "4496";
        String expectedValue = (String) redisUtilsService.get(key);

        assertEquals(expectedValue,actualValue,"Redis Test Fail");
    }
}