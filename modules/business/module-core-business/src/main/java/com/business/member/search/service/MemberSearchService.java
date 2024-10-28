package com.business.member.search.service;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import com.business.configuration.framework.utils.ObjectToolkits;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.model.vo.MemberInfoVo;
import com.business.member.search.repository.MemberQueryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

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
public class MemberSearchService {
    private final MemberQueryRepository memberRepository;

    public MemberInfoVo findMemberDetailByMemberId(@NotNull MemberCondDto dto) {

        if (ObjectToolkits.isEmpty(dto.getId())) {
            throw CoreExceptionHandler.handleBadRequestException(BasicErrorCode.INVALID_INPUT_VALUE);
        }

        return memberRepository.fetchMemberInfoVersion2(dto.getId());
    }


}
