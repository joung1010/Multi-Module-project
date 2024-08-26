package com.business.configuration.framework.data.jpa;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * <b> AbstractJpaDataSourceConfiguration </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-13
 */
public abstract class AbstractJpaDataSourceConfiguration  implements JpaDataSourceConfiguration {
    protected final JpaProperties jpaProperties;

    public AbstractJpaDataSourceConfiguration(final JpaProperties jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    @Override
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
