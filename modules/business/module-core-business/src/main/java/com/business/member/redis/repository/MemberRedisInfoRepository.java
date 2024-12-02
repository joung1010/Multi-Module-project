package com.business.member.redis.repository;

import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * <b> MemberRedisInfoRepository </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-12-02
 */

public interface MemberRedisInfoRepository extends CrudRepository<MemberRedisInfoEntity, String> {
}
