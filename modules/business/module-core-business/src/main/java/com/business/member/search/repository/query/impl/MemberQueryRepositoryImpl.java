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
        QTMemberEntity member = QTMemberEntity.tMemberEntity;
//        QTMemberDetailsEntity memberDetails = QTMemberDetailsEntity.tMemberDetailsEntity;
//        QTMemberAddressEntity address = QTMemberAddressEntity.tMemberAddressEntity;
//        QTShippingAddress shippingAddress = QTShippingAddress.tShippingAddress;


        return null;
    }
}
