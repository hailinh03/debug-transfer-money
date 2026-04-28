package org.example.debugtransfermoney.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;             // e.g. "BLACKFRIDAY50"

    @Column(nullable = false)
    private Integer remainingQuantity; // số lượng còn lại

    @Column(nullable = false)
    private Integer totalQuantity;     // tổng số phát hành
}

