package com.business.configuration.jpa;

import com.business.configuration.data.datasource.DefaultDataSourceConfig;
import com.business.configuration.jpa.framework.AbstractJpaDataSourceConfiguration;
import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-24
 */
@Slf4j
@EnableJpaRepositories(
        basePackages = {"com.business.**.repository"}, // JPA 리포지토리가 위치한 패키지를 지정합니다.
        entityManagerFactoryRef =DefaultJpaConfiguration.JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME,
        transactionManagerRef = DefaultJpaConfiguration.JPA_TX_MANAGER_BEAN_NAME
)
@Configuration
public class DefaultJpaConfiguration extends AbstractJpaDataSourceConfiguration {
    public static final String JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME = "jpa-entity-manager";
    public static final String JPA_TX_MANAGER_BEAN_NAME = "jpa-tx-manager";


    public DefaultJpaConfiguration(JpaProperties jpaProperties) {
        super(jpaProperties);
    }

    @Bean(JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(DefaultDataSourceConfig.DEFAULT_DATASOURCE) DataSource dataSource) {
        log.info("========= default jpa setting =========");
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.business.domain"); // JPA 엔티티가 위치한 패키지를 지정합니다.

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVendorAdapter());
        em.setPersistenceUnitName(JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME);
        em.setJpaPropertyMap(jpaProperties.getProperties());

        return em;
    }

    @ConditionalOnBean(name = JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME)
    @Bean(JPA_TX_MANAGER_BEAN_NAME)
    public PlatformTransactionManager jpaTransactionManager(@Qualifier(JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME) EntityManagerFactory entityManagerFactory) {
        return transactionManager(entityManagerFactory);
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
}
