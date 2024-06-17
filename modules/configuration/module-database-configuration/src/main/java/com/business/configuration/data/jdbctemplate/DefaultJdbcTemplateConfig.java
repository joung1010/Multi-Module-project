package com.business.configuration.data.jdbctemplate;

import com.business.configuration.data.contents.DataContents;
import com.business.configuration.data.datasource.DefaultDataSourceConfig;
import com.business.configuration.data.jdbctemplate.interfaces.DefaultJdbcTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-17
 */
@Slf4j
@Configuration
public class DefaultJdbcTemplateConfig implements DefaultJdbcTemplate {
    private static final String DEFAULT = "default";
    public static final String JDBC_TEMPLATE = DEFAULT + DataContents.CONJUNCTION + DataContents.JDBC_TEMPLATE;
    public static final String NM_JDBC_TEMPLATE = DEFAULT + DataContents.CONJUNCTION + DataContents.NM_JDBC_TEMPLATE;

    @Bean(JDBC_TEMPLATE)
    public JdbcTemplate jdbcTemplate(@Qualifier(DefaultDataSourceConfig.DEFAULT_DATASOURCE) DataSource dataSource) {
        log.info("========= default jdbc template setting =========");
        return new JdbcTemplate(dataSource);
    }

    @Bean(NM_JDBC_TEMPLATE)
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier(DefaultDataSourceConfig.DEFAULT_DATASOURCE) DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
