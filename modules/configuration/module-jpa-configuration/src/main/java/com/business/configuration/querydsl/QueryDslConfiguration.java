package com.business.configuration.querydsl;

import com.business.configuration.jpa.DefaultJpaConfiguration;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

/**
 * <b> QueryDslConfiguration </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-13
 */
@Slf4j
@Configuration
public class QueryDslConfiguration {
    public static final String QUERY_FACTORY_BEAN_NAME = "query-dsl-factory";

    @Bean(QUERY_FACTORY_BEAN_NAME)
    public JPAQueryFactory jpaQueryFactory(@Qualifier(DefaultJpaConfiguration.JPA_ENTITY_MANAGER_FACTORY_BEAN_NAME) EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
