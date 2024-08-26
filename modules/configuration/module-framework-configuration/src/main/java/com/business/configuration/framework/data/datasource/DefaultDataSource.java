package com.business.configuration.framework.data.datasource;

import com.business.configuration.framework.data.properties.DataSourceProperties;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-05-29
 */
public interface DefaultDataSource {
    DataSourceProperties dataSourceProperties();

    DataSource dataSource(DataSourceProperties dataSourceProperties);

    PlatformTransactionManager transactionManager(DataSource dataSource);
}
