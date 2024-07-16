package com.business.member.search.model.dto;

import lombok.*;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-07-16
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberCondDto {
    private Long id;
    private String userName;
    private String email;
    private String password;

}
