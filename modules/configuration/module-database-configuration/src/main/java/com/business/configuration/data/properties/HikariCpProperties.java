package com.business.configuration.data.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-05-29
 */

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "configuration.data.hikari")
public class HikariCpProperties {
    private String targetDatabaseType;
    private boolean autoCommit;
    private long connectionTimeout;
    private long validationTimeout;
    private long idleTimeout;
    private long maxLifetime;
    private int maximumPoolSize;
    private int minimumIdle;
    private long leakDetectionThreshold;
    private long keepaliveTime;
}
