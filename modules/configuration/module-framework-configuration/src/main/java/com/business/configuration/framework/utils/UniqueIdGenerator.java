package com.business.configuration.framework.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * <b> UniqueIdGenerator </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-09-23
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UniqueIdGenerator {
    public static String generateUuidNoDash() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
