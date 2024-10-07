package com.business.member.search.service.impl;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import com.business.configuration.framework.utils.ObjectToolkits;
import com.business.configuration.framework.utils.StringToolkits;
import com.business.domain.TMemberEntity;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.model.vo.MemberDetailVo;
import com.business.member.search.model.vo.MemberInfoVo;
import com.business.member.search.repository.MemberRepository;
import com.business.member.search.service.MemberSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-07-16
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberSearchServiceImpl implements MemberSearchService {
    private final MemberRepository memberRepository;

    @Override
    public MemberInfoVo findMemberDetailByMemberId(@NotNull MemberCondDto dto) {

        if (ObjectToolkits.isEmpty(dto.getId())) {
            throw CoreExceptionHandler.handleBadRequestException(BasicErrorCode.INVALID_INPUT_VALUE);
        }

        return memberRepository.fetchMemberInfoVersion2(dto.getId());
    }

    @Override
    public MemberDetailVo searchMemberInfoVersion1(MemberCondDto dto) {
        if (StringToolkits.isAllBlank(dto.getEmail(), dto.getPassword())
                && ObjectToolkits.isEmpty(dto.getId())) {
            //TODO 예외처리 로직 추가 필요
            throw new RuntimeException("필수 값 오류");
        }
        TMemberEntity tMember;
        if (ObjectToolkits.isNotEmpty(dto.getId())) {
            tMember = memberRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("회원 미존재"));
        } else {
            tMember = Optional.ofNullable(memberRepository.findByEmailAndPassword(dto))
                    .orElseThrow(() -> new RuntimeException("email 및 password 불일치"));
        }

        return MemberDetailVo.builder()
                .memberId(tMember.getId())
                .userName(tMember.getUsername())
                .email(tMember.getEmail())
                .address(tMember.getMemberDetails().getAddress())
                .birthdate(tMember.getMemberDetails().getBirthdate())
                .firstName(tMember.getMemberDetails().getFirstName())
                .lastName(tMember.getMemberDetails().getLastName())
                .phoneNumber(tMember.getMemberDetails().getPhoneNumber())
                .build();
    }
}
