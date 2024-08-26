package com.business.configuration.framework.data.datasource;

import com.business.configuration.framework.data.properties.DataSourceProperties;
import com.business.configuration.framework.data.properties.HikariCpProperties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-05-29
 */
@Slf4j
public abstract class AbstractDataSource implements DefaultDataSource{

    protected DataSource createDataSource(DataSourceProperties dataSourceProperties ,
                                          HikariCpProperties hikariCpProperties) {
        log.info("========= data source setting =========");
        log.info("Driver Class Name: {}", dataSourceProperties.getDriverClassName());
        log.info("JDBC URL: {}", dataSourceProperties.getPrefixHost() + dataSourceProperties.getHost());
        log.info("Username: {}", dataSourceProperties.getUsername());
        log.info("Password: {}", dataSourceProperties.getPassword());
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(dataSourceProperties.getDriverClassName());
        hikariConfig.setJdbcUrl(dataSourceProperties.getPrefixHost() + dataSourceProperties.getHost());
        hikariConfig.setUsername(dataSourceProperties.getUsername());
        hikariConfig.setPassword(dataSourceProperties.getPassword());

        hikariConfig.setAutoCommit(hikariCpProperties.isAutoCommit());
        hikariConfig.setConnectionTimeout(hikariCpProperties.getConnectionTimeout());
        hikariConfig.setValidationTimeout(hikariCpProperties.getValidationTimeout());
        hikariConfig.setIdleTimeout(hikariCpProperties.getIdleTimeout());
        hikariConfig.setMaxLifetime(hikariCpProperties.getMaxLifetime());
        hikariConfig.setMaximumPoolSize(hikariCpProperties.getMaximumPoolSize());
        hikariConfig.setMinimumIdle(hikariCpProperties.getMinimumIdle());
        hikariConfig.setLeakDetectionThreshold(hikariCpProperties.getLeakDetectionThreshold());
        hikariConfig.setKeepaliveTime(hikariCpProperties.getKeepaliveTime());

        log.info("========= data source setting end =========");
        return new HikariDataSource(hikariConfig);
    }
}
