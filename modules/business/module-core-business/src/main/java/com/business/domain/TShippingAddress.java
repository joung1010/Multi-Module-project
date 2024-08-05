package com.business.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <b> TShippingAddress </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-08-05
 */
@Entity
@Getter
@Setter
@Table(name = "T_SHIPPING_ADDRESS")
public class TShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipping_address", nullable = false, length = 255)
    private String shippingAddress;

    @Column(name = "shipping_city", nullable = false, length = 100)
    private String shippingCity;

    @Column(name = "shipping_state", nullable = false, length = 100)
    private String shippingState;

    @Column(name = "shipping_zipcode", nullable = false, length = 100)
    private String shippingZipcode;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    TMemberAddressEntity memberAddress;
}
