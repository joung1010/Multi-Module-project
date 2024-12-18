package com.business.member.search.repository;

import com.business.member.search.model.vo.MemberInfoVo;

/**
 * <b> MemberQueryRepository </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-19
 */
public interface MemberQueryRepository {
    MemberInfoVo fetchMemberInfo(Long memberId);

    MemberInfoVo fetchMemberInfoVersion2(Long memberId);
}
