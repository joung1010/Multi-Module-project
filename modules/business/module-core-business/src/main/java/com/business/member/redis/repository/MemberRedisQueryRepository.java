package com.business.member.redis.repository;

import com.business.member.redis.model.MemberRedisAddressVo;
import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import com.business.member.redis.model.MemberRedisShippingAddressVo;

import java.util.List;

/**
 * <b> MemberRedisQueryRepository </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */
public interface MemberRedisQueryRepository {
    MemberRedisInfoEntity findMemberInfo(long memberId);
    List<MemberRedisAddressVo> findAllMemberAddress(long memberId);
    List<MemberRedisShippingAddressVo> findAllMemberShippingAddress(long memberId);
}
