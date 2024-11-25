package com.business.member.redis.model;

import lombok.Getter;

import java.io.Serializable;

/**
 * <b> MemberRedisShippingAddressVo </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */

@Getter
public class MemberRedisShippingAddressVo implements Serializable {
    private static final long serialVersionUID = -481803296602015044L;

    private String shippingAddress;
    private String shippingCity;
    private String shippingState;
    private String shippingZipcode;
}
