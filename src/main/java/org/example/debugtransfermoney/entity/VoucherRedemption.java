package org.example.debugtransfermoney.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "voucher_redemptions")
@Getter
@Setter
public class VoucherRedemption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long voucherId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDateTime redeemedAt;
}