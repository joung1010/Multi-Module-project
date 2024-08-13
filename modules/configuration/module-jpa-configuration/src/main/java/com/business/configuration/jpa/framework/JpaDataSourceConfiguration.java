package com.business.configuration.jpa.framework;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * <b> JpaDataSourceConfiguration </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-13
 */
public interface JpaDataSourceConfiguration {
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource);

    PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory);

    default JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }
}
