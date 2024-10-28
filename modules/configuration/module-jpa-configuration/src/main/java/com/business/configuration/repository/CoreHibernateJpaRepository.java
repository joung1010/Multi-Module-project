package com.business.configuration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

/**
 * <b> CoreJpaRepository </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-28
 */
@NoRepositoryBean
public interface CoreHibernateJpaRepository<T, ID>
        extends JpaRepository<T, ID>, QueryByExampleExecutor<T> {

    <S extends T> S persist(S entity);

    <S extends T> S persistAndFlush(S entity);

    <S extends T> List<S> persistAll(Iterable<S> entities);

    <S extends T> List<S> persistAllAndFlush(Iterable<S> entities);

    <S extends T> S merge(S entity);

    <S extends T> S mergeAndFlush(S entity);

    <S extends T> List<S> mergeAll(Iterable<S> entities);

    <S extends T> List<S> mergeAllAndFlush(Iterable<S> entities);

    <S extends T> S update(S entity);

    <S extends T> S updateAndFlush(S entity);

    <S extends T> List<S> updateAll(Iterable<S> entities);

    <S extends T> List<S> updateAllAndFlush(Iterable<S> entities);
}
