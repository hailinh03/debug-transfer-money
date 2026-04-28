package org.example.debugtransfermoney.repository;

import org.example.debugtransfermoney.entity.VoucherRedemption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRedemptionRepository extends JpaRepository<VoucherRedemption, Long> {
    long countByVoucherId(Long voucherId);
}