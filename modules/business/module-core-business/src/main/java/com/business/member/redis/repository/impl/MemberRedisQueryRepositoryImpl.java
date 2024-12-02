package com.business.member.redis.repository.impl;

import com.business.domain.QTMemberAddressEntity;
import com.business.domain.QTMemberDetailsEntity;
import com.business.domain.QTMemberEntity;
import com.business.domain.QTShippingAddress;
import com.business.member.redis.model.MemberRedisAddressVo;
import com.business.member.redis.model.entity.MemberRedisInfoEntity;
import com.business.member.redis.model.MemberRedisShippingAddressVo;
import com.business.member.redis.repository.MemberRedisQueryRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b> MemberRedisQueryRepositoryImpl </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRedisQueryRepositoryImpl implements MemberRedisQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberRedisInfoEntity findMemberInfo(long memberId) {
        QTMemberEntity member = QTMemberEntity.tMemberEntity;
        QTMemberDetailsEntity memberDetails = QTMemberDetailsEntity.tMemberDetailsEntity;

        return jpaQueryFactory
                .select(Projections.fields(
                        MemberRedisInfoEntity.class,
                        member.id.as("memberId"),
                        member.username.as("userName"),
                        member.email.as("email"),
                        memberDetails.firstName.as("firstName"),
                        memberDetails.lastName.as("lastName"),
                        memberDetails.phoneNumber.as("phoneNumber"),
                        memberDetails.address.as("address"),
                        memberDetails.birthdate.as("birthdate")
                ))
                .from(member)
                .join(member.memberDetails, memberDetails)
                .where(member.id.eq(memberId))
                .fetchOne();
    }

    @Override
    public List<MemberRedisAddressVo> findAllMemberAddress(long memberId) {
        QTMemberAddressEntity address = QTMemberAddressEntity.tMemberAddressEntity;

        return jpaQueryFactory
                .select(Projections.fields(
                        MemberRedisAddressVo.class,
                        address.address.as("address"),
                        address.city.as("city"),
                        address.state.as("state"),
                        address.zipcode.as("zipcode")
                ))
                .from(address)
                .where(address.member.id.eq(memberId))
                .fetch();
    }

    @Override
    public List<MemberRedisShippingAddressVo> findAllMemberShippingAddress(long memberId) {
        QTMemberAddressEntity address = QTMemberAddressEntity.tMemberAddressEntity;
        QTShippingAddress shippingAddress = QTShippingAddress.tShippingAddress;

        return  jpaQueryFactory
                .select(Projections.fields(
                        MemberRedisShippingAddressVo.class,
                        shippingAddress.shippingAddress.as("shippingAddress"),
                        shippingAddress.shippingCity.as("shippingCity"),
                        shippingAddress.shippingState.as("shippingState"),
                        shippingAddress.shippingZipcode.as("shippingZipcode")
                ))
                .from(shippingAddress)
                .join(shippingAddress.memberAddress, address)
                .where(address.member.id.eq(memberId))
                .fetch();
    }
}
