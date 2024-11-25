package com.business.member.redis.model;

import lombok.Getter;

import java.io.Serializable;

/**
 * <b> MemberRedisAddressVo </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */

@Getter
public class MemberRedisAddressVo implements Serializable {
    private static final long serialVersionUID = 8300234443971733944L;

    private String address;
    private String city;
    private String state;
    private String zipcode;
}
