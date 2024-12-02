package com.business.member.redis.service;

import com.business.configuration.framework.utils.ObjectToolkits;
import com.business.member.redis.model.MemberRedisAddressVo;
import com.business.member.redis.model.MemberRedisShippingAddressVo;
import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import com.business.member.redis.repository.MemberRedisInfoRepository;
import com.business.member.redis.repository.MemberRedisQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b> MemberRedisInfoLoadService </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */

@Slf4j
@RequiredArgsConstructor

@Service
public class MemberRedisInfoLoadService {
    private final MemberRedisQueryRepository repository;
    private final MemberRedisInfoRepository redisRepository;

    public MemberRedisInfoEntity load(Long memberId) {
        MemberRedisInfoEntity memberInfo = repository.findMemberInfo(memberId);

        if (ObjectToolkits.isEmpty(memberInfo)) {
            return null;
        }

        List<MemberRedisAddressVo> address = repository.findAllMemberAddress(memberId);
        List<MemberRedisShippingAddressVo> shipAddress = repository.findAllMemberShippingAddress(memberId);
        memberInfo.setMemberAddressInfo(address,shipAddress);

        return redisRepository.save(memberInfo);
    }

}
