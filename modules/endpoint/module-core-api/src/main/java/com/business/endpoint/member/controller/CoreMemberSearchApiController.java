package com.business.endpoint.member.controller;

import com.business.configuration.framework.exception.enums.BasicErrorCode;
import com.business.configuration.framework.exception.handler.CoreExceptionHandler;
import com.business.configuration.framework.exception.handler.RestApiController;
import com.business.configuration.framework.standard.http.CoreHttpResponseEntity;
import com.business.configuration.framework.standard.http.body.CoreHttpResponseBodyEntity;
import com.business.configuration.framework.standard.http.provider.CoreHttpResponseProvider;
import com.business.configuration.framework.utils.MessageToolkits;
import com.business.endpoint.member.model.dto.MemberInfoSearchDto;
import com.business.endpoint.member.service.CoreMemberApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b> CoreMemberQueryController </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-07
 */

@Slf4j
@RequiredArgsConstructor
@RestApiController
@RequestMapping("/api/core/member/v1")
public class CoreMemberSearchApiController {

    private final CoreMemberApiService searchService;

    @GetMapping("/search")
    public CoreHttpResponseEntity searchMemberInfo(MemberInfoSearchDto.Request reqDto) {

        MemberInfoSearchDto.Response response = searchService.searchMemberInfo(reqDto);
        throw CoreExceptionHandler.handleUnknownException(BasicErrorCode.INTERNAL_SERVER_ERROR);
//        return CoreHttpResponseProvider.responseSuccess(response);
    }

}
