package org.example.debugtransfermoney.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "voucher_redemptions")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoucherRedemption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long voucherId;

    @Column(nullable = false)
    private Long userId;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime redeemedAt;
}