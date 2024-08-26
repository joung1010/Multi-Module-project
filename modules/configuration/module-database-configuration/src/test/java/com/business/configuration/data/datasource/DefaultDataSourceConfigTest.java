package com.business.configuration.data.datasource;

import com.business.configuration.TestApplication;
import com.business.configuration.framework.data.properties.DataSourceProperties;
import com.business.configuration.framework.data.properties.HikariCpProperties;
import com.business.configuration.jasypt.JasyptConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
class DefaultDataSourceConfigTest {

    @Autowired
    JasyptConfig jasyptConfig;

    @Autowired
    private HikariCpProperties hikariCpProperties;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Test
    void contextLoads() {
        assertThat(jasyptConfig).isNotNull();
        assertThat(hikariCpProperties).isNotNull();
        assertThat(hikariCpProperties.getTargetDatabaseType()).isEqualTo("mysql");

        // 데이터 소스 속성 확인
        assertThat(dataSourceProperties).isNotNull();
        log.info("Decrypted Username: {}", dataSourceProperties.getUsername());
        log.info("Decrypted Password: {}", dataSourceProperties.getPassword());
        log.info("Driver Class Name: {}", dataSourceProperties.getDriverClassName());
        log.info("Prefix Host: {}", dataSourceProperties.getPrefixHost());
        log.info("Host: {}", dataSourceProperties.getHost());

        // 추가적인 검증 코드
        assertThat(dataSourceProperties.getUsername()).isEqualTo("root");  // 예시 검증
    }

}
