package com.business.member.search.service;

import com.business.member.search.model.dto.MemberCondDto;
import com.business.member.search.model.vo.MemberDetailVo;
import com.business.member.search.model.vo.MemberInfoVo;

/**
 * <b> MemberSearchService </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-07
 */
public interface MemberSearchService {
    MemberInfoVo findMemberDetailByMemberId(MemberCondDto dto);

    MemberDetailVo searchMemberInfoVersion1(MemberCondDto dto);

}
