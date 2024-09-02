package com.business.member.search.repository.query.impl;

import com.business.configuration.framework.utils.CollectionToolkits;
import com.business.configuration.framework.utils.ObjectToolkits;
import com.business.domain.*;
import com.business.member.search.model.vo.MemberInfoVo;
import com.business.member.search.repository.query.MemberQueryRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;


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
        QTMemberDetailsEntity memberDetails = QTMemberDetailsEntity.tMemberDetailsEntity;
        QTMemberAddressEntity address = QTMemberAddressEntity.tMemberAddressEntity;
        QTShippingAddress shippingAddress = QTShippingAddress.tShippingAddress;

        TMemberEntity memberResult = jpaQueryFactory.selectFrom(member)
                .join(member.memberDetails, memberDetails).fetchJoin() // TMemberEntity와 TMemberDetailsEntity 간의 조인
                .leftJoin(address).on(address.member.eq(member)).fetchJoin() // TMemberEntity와 TMemberAddressEntity 간의 조인
                .leftJoin(shippingAddress).on(shippingAddress.memberAddress.eq(address)).fetchJoin() // TMemberAddressEntity와 TShippingAddress 간의 조인
                .where(member.id.eq(memberId))
                .fetchOne();

        if (ObjectToolkits.isEmpty(memberResult)) {
            throw new RuntimeException("회원 미존재");
        }

        List<MemberInfoVo.MemberAddress> memberAddr = jpaQueryFactory.selectFrom(address)
                .where(address.member.eq(memberResult))
                .fetch()
                .stream()
                .map(addr -> MemberInfoVo.MemberAddress.builder()
                        .id(addr.getId())
                        .address(addr.getAddress())
                        .city(addr.getCity())
                        .state(addr.getState())
                        .zipcode(addr.getZipcode())
                        .build())
                .toList();

        List<MemberInfoVo.ShippingAddress> shipAddr = jpaQueryFactory.selectFrom(shippingAddress)
                .where(shippingAddress.memberAddress.member.eq(memberResult))
                .fetch()
                .stream()
                .map(ship -> MemberInfoVo.ShippingAddress.builder()
                        .id(ship.getId())
                        .shippingAddress(ship.getShippingAddress())
                        .shippingCity(ship.getShippingCity())
                        .shippingState(ship.getShippingState())
                        .shippingZipcode(ship.getShippingZipcode())
                        .build())
                .toList();

        return MemberInfoVo.builder()
                .memberId(memberResult.getId())
                .userName(memberResult.getUsername())
                .email(memberResult.getEmail())
                .password(memberResult.getPassword())
                .firstName(memberResult.getMemberDetails().getFirstName())
                .lastName(memberResult.getMemberDetails().getLastName())
                .phoneNumber(memberResult.getMemberDetails().getPhoneNumber())
                .address(memberResult.getMemberDetails().getAddress())
                .birthdate(memberResult.getMemberDetails().getBirthdate())
                .memberAddress(memberAddr)
                .shippingAddresses(shipAddr)
                .build();

    }

    @Override
    public MemberInfoVo fetchMemberInfoVersion2(Long memberId) {
        QTMemberEntity member = QTMemberEntity.tMemberEntity;
        QTMemberDetailsEntity memberDetails = QTMemberDetailsEntity.tMemberDetailsEntity;
        QTMemberAddressEntity address = QTMemberAddressEntity.tMemberAddressEntity;
        QTShippingAddress shippingAddress = QTShippingAddress.tShippingAddress;

        TMemberEntity memberResult = jpaQueryFactory
                .selectFrom(member)
                .join(member.memberDetails, memberDetails).fetchJoin()
                .leftJoin(address).on(address.member.eq(member)).fetchJoin()
                .leftJoin(shippingAddress).on(shippingAddress.memberAddress.eq(address)).fetchJoin()
                .where(member.id.eq(memberId))
                .select(member)  // 소유자 엔티티를 select 절에 포함시킴
                .fetchOne();

        if (memberResult == null) {
            throw new RuntimeException("회원 미존재");
        }

        // Address 정보 가져오기
        List<MemberInfoVo.MemberAddress> memberAddr = jpaQueryFactory
                .select(Projections.fields(
                        MemberInfoVo.MemberAddress.class,
                        address.id.as("id"),
                        address.address.as("address"),
                        address.city.as("city"),
                        address.state.as("state"),
                        address.zipcode.as("zipcode")
                ))
                .from(address)
                .where(address.member.eq(memberResult))
                .fetch();

        // Shipping Address 정보 가져오기
        List<MemberInfoVo.ShippingAddress> shipAddr = jpaQueryFactory
                .select(Projections.fields(
                        MemberInfoVo.ShippingAddress.class,
                        shippingAddress.id.as("id"),
                        shippingAddress.shippingAddress.as("shippingAddress"),
                        shippingAddress.shippingCity.as("shippingCity"),
                        shippingAddress.shippingState.as("shippingState"),
                        shippingAddress.shippingZipcode.as("shippingZipcode")
                ))
                .from(shippingAddress)
                .where(shippingAddress.memberAddress.member.eq(memberResult))
                .fetch();

        // MemberInfoVo 객체 생성
        return MemberInfoVo.builder()
                .memberId(memberResult.getId())
                .userName(memberResult.getUsername())
                .email(memberResult.getEmail())
                .password(memberResult.getPassword())
                .firstName(memberResult.getMemberDetails().getFirstName())
                .lastName(memberResult.getMemberDetails().getLastName())
                .phoneNumber(memberResult.getMemberDetails().getPhoneNumber())
                .address(memberResult.getMemberDetails().getAddress())
                .birthdate(memberResult.getMemberDetails().getBirthdate())
                .memberAddress(memberAddr)
                .shippingAddresses(shipAddr)
                .build();
    }
}
