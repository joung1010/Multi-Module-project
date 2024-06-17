package com.business.configuration.data.properties;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-17
 */

@Slf4j
@SpringBootTest(classes = {HikariCpProperties.class})
@ConfigurationPropertiesScan("com.business.configuration")
@ActiveProfiles("test")
class HikariCpPropertiesTest {
    @Autowired
    private HikariCpProperties hikariCpProperties;

    @Test
    void contextLoads() {
        assertThat(hikariCpProperties).isNotNull();
        assertThat(hikariCpProperties.getTargetDatabaseType()).isEqualTo("mysql");
        // 추가적인 검증 코드
    }
}