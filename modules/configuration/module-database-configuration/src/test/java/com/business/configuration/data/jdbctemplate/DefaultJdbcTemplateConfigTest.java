package com.business.configuration.data.jdbctemplate;

import com.business.configuration.TestApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-19
 */

@Slf4j
@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
class DefaultJdbcTemplateConfigTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    void jdbcTest() {
        assertNotNull(jdbcTemplate);

        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM mbr_v10.T_MEMBER", Integer.class);
        assertNotNull(count);
        log.info("count : {}",count);
    }

    @Test
    void namedParameterJdbcTest() {
        assertNotNull(namedParameterJdbcTemplate);
        Map<String,Object> params = new HashMap<>();
        params.put("username", "john_doe");

        String userName = namedParameterJdbcTemplate.queryForObject("select username from mbr_v10.T_MEMBER WHERE username = :username", params, String.class);
        assertNotNull(userName);
        assertEquals("john_doe",userName);
    }

}