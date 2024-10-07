package com.business.endpoint.member.service;

import com.business.endpoint.member.model.dto.MemberInfoSearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public MemberInfoSearchDto.Response searchMemberInfo(MemberInfoSearchDto.Request reqDto) {
        return null;
    }
}
