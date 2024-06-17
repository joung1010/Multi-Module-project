package com.business.configuration.data.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-17
 */
@Repository
@RequiredArgsConstructor
public class DefaultJdbcTemplateRepositoryTest {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void executeQuery(String sql) {
        jdbcTemplate.queryForList(sql)
                .forEach(System.out::println);
    }

}
