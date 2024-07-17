package com.business.member.search.service;

import com.business.domain.TMemberEntity;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.model.vo.MemberDetailVo;
import com.business.member.search.repository.jpa.MemberSearchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
public class SearchMemberService {
    private final MemberSearchRepository memberSearchRepository;

    public MemberDetailVo searchMemberInfo(MemberCondDto dto) {
        if (StringUtils.isAllBlank(dto.getEmail(), dto.getPassword())
                && ObjectUtils.isEmpty(dto.getId())) {
            //TODO 예외처리 로직 추가 필요
            throw new RuntimeException("필수 값 오류");
        }
        TMemberEntity tMember;
        if (ObjectUtils.isNotEmpty(dto.getId())) {
            tMember = memberSearchRepository.findById(dto.getId())
                    .orElseThrow(() -> new RuntimeException("회원 미존재"));
        } else {
            tMember = Optional.ofNullable(memberSearchRepository.findByEmailAndPassword(dto))
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
