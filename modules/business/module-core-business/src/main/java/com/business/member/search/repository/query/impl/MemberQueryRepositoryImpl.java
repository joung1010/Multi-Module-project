package com.business.member.search.repository.query.impl;

import com.business.domain.*;
import com.business.member.search.model.vo.MemberInfoVo;
import com.business.member.search.repository.query.MemberQueryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;


/**
 * <b> MemberQueryRepositoryImpl </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-19
 */
@Slf4j
@RequiredArgsConstructor
@Repository
public class MemberQueryRepositoryImpl implements MemberQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberInfoVo fetchMemberInfo(Long memberId) {
//        QTMemberEntity member = QTMemberEntity.tMemberEntity;
//        QTMemberDetailsEntity memberDetails = QTMemberDetailsEntity.tMemberDetailsEntity;
//        QTMemberAddressEntity address = QTMemberAddressEntity.tMemberAddressEntity;
//        QTShippingAddress shippingAddress = QTShippingAddress.tShippingAddress;

/*        TMemberEntity memberResult
                = jpaQueryFactory.selectFrom(member)
                .join(member.memberDetails, memberDetails).fetchJoin()  // TMemberEntity와 TMemberDetailsEntity 간의 관계에 따른 조인
                .leftJoin(address)
                    .on(address.member.eq(member)).fetchJoin()  // TMemberEntity와 TMemberAddressEntity 간의 관계에 따른 조인
                .leftJoin(shippingAddress)
                    .on(shippingAddress.memberAddress.eq(address)).fetchJoin()  // TMemberAddressEntity와 TShippingAddress 간의 관계에 따른 조인
                .where(member.id.eq(memberId))
                .fetchOne();*/

        return null;
    }
}
