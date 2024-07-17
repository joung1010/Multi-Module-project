package com.business.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-07-16
 */
@Entity
@Getter
@Setter
@Table(name = "T_MEMBER_DETAILS")
public class TMemberDetailsEntity {
    @Id
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(length = 255)
    private String address;

    private LocalDate birthdate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @OneToOne
    @MapsId
    @JoinColumn(name = "member_id")
    private TMemberEntity member;
}
