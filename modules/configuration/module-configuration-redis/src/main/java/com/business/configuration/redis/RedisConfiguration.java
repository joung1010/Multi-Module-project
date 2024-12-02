package com.business.configuration.redis;

import com.business.configuration.framework.utils.StringToolkits;
import com.business.configuration.redis.properties.RedisProperties;
import io.lettuce.core.ClientOptions;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * <b> RedisConfiguration </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-11
 */
@Configuration
@RequiredArgsConstructor
@EnableRedisRepositories(basePackages = "com.business.**.repository")
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfiguration {
    private final RedisProperties properties;
    public static final String REDIS_FACTORY = "redis-factory";
    public static final String REDIS_TEMPLATE = "redis-template";

    @Bean(REDIS_FACTORY)
    public RedisConnectionFactory redisConnectionFactory() {

        // 클러스터 토폴로지 갱신 설정 추가
        ClusterTopologyRefreshOptions topologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
                .enablePeriodicRefresh(Duration.ofMinutes(30)) // 주기적인 갱신 (30분마다)
                .enableAllAdaptiveRefreshTriggers() // 변경 감지 및 자동 갱신 트리거 활성화
                .build();

        ClientOptions clientOptions = ClusterClientOptions.builder()
                .topologyRefreshOptions(topologyRefreshOptions)
                .build();

        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(properties.timeout())) // timeout 설정
                .clientOptions(clientOptions) // 갱신 옵션 적용
                .build();

        if (properties.cluster().enabled()) {
            // 클러스터 모드 설정
            RedisClusterConfiguration clusterConfig = new RedisClusterConfiguration(properties.cluster().nodes());
            if (StringToolkits.isNoneBlank()) {
                clusterConfig.setPassword(properties.password());
            }

            clusterConfig.setPassword(properties.password());
            return new LettuceConnectionFactory(clusterConfig, clientConfig);
        } else {
            // 단일 Redis 서버 설정
            RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration();
            standaloneConfig.setHostName(properties.host());
            standaloneConfig.setPort(properties.port());

            if (StringToolkits.isNoneBlank()) {
                standaloneConfig.setPassword(properties.password()); // password 설정
            }

            return new LettuceConnectionFactory(standaloneConfig, clientConfig);
        }

    }

    @Bean(REDIS_TEMPLATE)
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

}
