package com.business.configuration.framework.data.jdbc;

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
public interface DefaultJdbcTemplate {
    JdbcTemplate jdbcTemplate(DataSource dataSource);
    NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource);
}

