package com.business.endpoint.member.service;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import com.business.endpoint.member.model.dto.MemberInfoSearchDto;
import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.model.vo.MemberInfoVo;
import com.business.member.search.service.MemberSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <b> CoreMemberApiService </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-07
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class CoreMemberApiService {
    private final MemberSearchService searchService;

    public MemberInfoSearchDto.Response searchMemberInfo(MemberInfoSearchDto.Request reqDto) {

        MemberCondDto searchDto = MemberCondDto.builder()
                .id(reqDto.getId())
                .build();

        MemberInfoVo infoVo = Optional.ofNullable(searchService.findMemberDetailByMemberId(searchDto))
                .orElseThrow(() -> CoreExceptionHandler.handleDatabaseException(BasicErrorCode.DATABASE_ERROR));

        return MemberInfoSearchDto.Response.builder()
                .memberId(infoVo.getMemberId())
                .userName(infoVo.getUserName())
                .email(infoVo.getEmail())
                .password(infoVo.getPassword())
                .firstName(infoVo.getFirstName())
                .lastName(infoVo.getLastName())
                .phoneNumber(infoVo.getPhoneNumber())
                .address(infoVo.getAddress())
                .birthdate(infoVo.getBirthdate())
                .build();
    }
}
