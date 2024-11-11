package com.business.configuration.redis.properties;

import org.springframework.boot.context.properties.ConfigurationProperties; // @ConfigurationProperties

import java.util.List;

/**
 * <b> RedisProperties </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-11
 */

@ConfigurationProperties(prefix = "configuration.data.redis")
public record RedisProperties(
        String host,
        int port,
        String password,
        int timeout,
        Cluster cluster

) {
    public static record Cluster(
            boolean enabled,
            List<String> nodes
    ) {}

}
