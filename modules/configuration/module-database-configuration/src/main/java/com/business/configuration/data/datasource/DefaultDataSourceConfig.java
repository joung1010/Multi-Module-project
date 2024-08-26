package com.business.configuration.data.datasource;

import com.business.configuration.data.contents.DataContents;
import com.business.configuration.framework.data.datasource.AbstractDataSource;
import com.business.configuration.framework.data.properties.DataSourceProperties;
import com.business.configuration.framework.data.properties.HikariCpProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-05-29
 */
@RequiredArgsConstructor
@Configuration
public class DefaultDataSourceConfig extends AbstractDataSource {

    private final HikariCpProperties hikariCpProperties;

    private static final String PREFIX = "default";
    public static final String DEFAULT_DB_PROPERTY = PREFIX + DataContents.CONJUNCTION + DataContents.DB_PROPERTY;
    public static final String DEFAULT_DATASOURCE = PREFIX + DataContents.CONJUNCTION + DataContents.DATASOURCE;
    public static final String DEFAULT_TX_MANAGER = PREFIX + DataContents.TX_MANAGER;

    @Bean(DEFAULT_DB_PROPERTY)
    @ConfigurationProperties(prefix = "configuration.data.datasource.mysql")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(DEFAULT_DATASOURCE)
    public DataSource dataSource(@Qualifier(DEFAULT_DB_PROPERTY) DataSourceProperties dataSourceProperties) {
        return super.createDataSource(dataSourceProperties, hikariCpProperties);
    }

    @Bean(DEFAULT_TX_MANAGER)
    public PlatformTransactionManager transactionManager(@Qualifier(DEFAULT_DATASOURCE) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
