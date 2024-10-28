package com.business.configuration.repository.impl;

import com.business.configuration.framework.utils.ObjectToolkits;
import com.business.configuration.repository.CoreHibernateJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.AbstractSharedSessionContract;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * <b> CoreJpaRepositoryImpl </b>
 * <p>
 * Implementation of the custom CoreJpaRepository methods for managing entities persist, merge, and update operations.
 *
 * @param <T>  the type of entity
 * @param <ID> the type of entity identifier
 */
public class CoreHibernateJpaRepositoryImpl<T, ID>
        extends SimpleJpaRepository<T, ID>
        implements CoreHibernateJpaRepository<T, ID> {

    @PersistenceContext
    private EntityManager entityManager;

    private final JpaEntityInformation<T, ?> entityInformation;

    public CoreHibernateJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public <S extends T> S persist(S entity) {

        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public <S extends T> S persistAndFlush(S entity) {

        entityManager.persist(entity);
        entityManager.flush();

        return entity;
    }

    @Override
    @Transactional
    public <S extends T> List<S> persistAll(Iterable<S> entities) {

        List<S> result = new ArrayList<>();
        for (S entity : entities) {
            entityManager.persist(entity);
            result.add(entity);
        }

        return result;
    }

    @Override
    @Transactional
    public <S extends T> List<S> persistAllAndFlush(Iterable<S> entities) {

        List<S> result = persistAll(entities);
        entityManager.flush();

        return result;
    }

    @Override
    @Transactional
    public <S extends T> S merge(S entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public <S extends T> S mergeAndFlush(S entity) {

        S mergedEntity = entityManager.merge(entity);
        entityManager.flush();

        return mergedEntity;
    }

    @Override
    @Transactional
    public <S extends T> List<S> mergeAll(Iterable<S> entities) {

        List<S> result = new ArrayList<>();
        for (S entity : entities) {
            result.add(entityManager.merge(entity));
        }

        return result;
    }

    @Override
    @Transactional
    public <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities) {

        List<S> result = mergeAll(entities);
        entityManager.flush();

        return result;
    }

    @Override
    @Transactional
    public <S extends T> S update(S entity) {

        Session session = session();
        session.merge(entity);

        return entity;
    }

    @Override
    @Transactional
    public <S extends T> S updateAndFlush(S entity) {

        update(entity);
        entityManager.flush();

        return entity;
    }

    @Override
    @Transactional
    public <S extends T> List<S> updateAll(Iterable<S> entities) {
        return executeBatch(() -> {
            List<S> result = new ArrayList<>();
            for (S entity : entities) {
                result.add(update(entity));
            }

            this.entityManager.flush();
            return result;
        });
    }

    @Override
    @Transactional
    public <S extends T> List<S> updateAllAndFlush(Iterable<S> entities) {

        List<S> result = updateAll(entities);
        entityManager.flush();

        return result;
    }


    protected Integer getBatchSize(Session session) {

        SessionFactoryImplementor sessionFactory
                = session
                .getSessionFactory()
                .unwrap(SessionFactoryImplementor.class);

        final JdbcServices jdbcServices = sessionFactory.getServiceRegistry().getService(JdbcServices.class);
        if (!jdbcServices.getExtractedMetaDataSupport().supportsBatchUpdates()) {
            return Integer.MIN_VALUE;
        }
        return session.unwrap(AbstractSharedSessionContract.class).getConfiguredJdbcBatchSize();
    }

    protected <R> R executeBatch(Supplier<R> callback) {
        Session session = session();
        Integer jdbcBatchSize = getBatchSize(session);
        Integer originalSessionBatchSize = session.getJdbcBatchSize();

        try {
            if (ObjectToolkits.isEmpty(jdbcBatchSize)) {
                session.setJdbcBatchSize(10);
            }

            return callback.get();
        } finally {
            session.setJdbcBatchSize(originalSessionBatchSize);
        }

    }

    protected Session session() {
        return entityManager.unwrap(Session.class);
    }

}
