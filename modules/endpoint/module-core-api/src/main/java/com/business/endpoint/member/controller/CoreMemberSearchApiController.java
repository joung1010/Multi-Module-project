package com.business.endpoint.member.controller;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import com.business.configuration.framework.exception.handler.RestApiController;
import com.business.configuration.framework.standard.http.CoreHttpResponseEntity;
import com.business.configuration.framework.standard.http.body.CoreHttpResponseBodyEntity;
import com.business.configuration.framework.standard.http.provider.CoreHttpResponseProvider;
import com.business.configuration.framework.standard.validation.annoation.ValidId;
import com.business.endpoint.member.model.dto.MemberInfoSearchDto;
import com.business.endpoint.member.service.CoreMemberApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b> CoreMemberQueryController </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-07
 */

@Slf4j
@Validated
@RequiredArgsConstructor
@RestApiController
@RequestMapping("/api/core/{version}/members")
public class CoreMemberSearchApiController {

    private final CoreMemberApiService searchService;

    @GetMapping("/{memberId}")
    public CoreHttpResponseBodyEntity<MemberInfoSearchDto.Response> searchMemberInfo(@ValidId @PathVariable("memberId") String memberId) {

        MemberInfoSearchDto.Request reqDto = MemberInfoSearchDto.Request.builder()
                .id(Long.parseLong(memberId))
                .build();
        MemberInfoSearchDto.Response response = searchService.searchMemberInfo(reqDto);

        return CoreHttpResponseProvider.responseSuccess(response);
    }
}
