package com.business.endpoint.member.model.dto;

import lombok.*;

import java.time.LocalDate;

/**
 * <b> MemberInfoSearchDto </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-10-07
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberInfoSearchDto {

    @Getter
    @Setter
    public static class Request {
        private Long id;
    }

    @Getter
    @Setter
    @Builder
    public static class Response {
        private Long memberId;
        private String userName;
        private String email;
        private String password;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String address;
        private LocalDate birthdate;
    }
}
