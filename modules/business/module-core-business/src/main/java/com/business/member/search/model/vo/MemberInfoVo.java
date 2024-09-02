package com.business.member.search.model.vo;

import com.business.domain.TMemberAddressEntity;
import com.business.domain.TMemberDetailsEntity;
import com.business.domain.TMemberEntity;
import com.business.domain.TShippingAddress;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <b> MemberInfoVo </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-19
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberInfoVo {

    private Long memberId;
    private String userName;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private LocalDate birthdate;
    private List<MemberAddress> memberAddress;
    private List<ShippingAddress> shippingAddresses;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MemberAddress {
        private Long id;
        private String address;
        private String city;
        private String state;
        private String zipcode;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ShippingAddress {
        private Long id;
        private String shippingAddress;
        private String shippingCity;
        private String shippingState;
        private String shippingZipcode;
    }

}
