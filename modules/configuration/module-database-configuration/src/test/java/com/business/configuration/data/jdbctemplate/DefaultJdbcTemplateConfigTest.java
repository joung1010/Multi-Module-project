package com.business.configuration.data.jdbctemplate;

import com.business.configuration.data.datasource.DefaultDataSourceConfig;
import com.business.configuration.data.repository.DefaultJdbcTemplateRepositoryTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-17
 */
@Slf4j
@SpringBootTest(classes = {DefaultDataSourceConfig.class,DefaultJdbcTemplateConfig.class, DefaultJdbcTemplateRepositoryTest.class})
@ActiveProfiles("test")
class DefaultJdbcTemplateConfigTest {

    @Autowired
    private DefaultJdbcTemplateRepositoryTest jdbcTemplateRepository;


    @DisplayName("Query Test")
    @Test
    void executeQueryTest() {
        jdbcTemplateRepository.executeQuery("SELECT * FROM mbr_v10.T_MEMBER");
    }
}