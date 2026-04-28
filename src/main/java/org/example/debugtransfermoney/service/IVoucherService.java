package org.example.debugtransfermoney.service;

import org.example.debugtransfermoney.dto.RedeemResult;

public interface IVoucherService {
    public RedeemResult redeemVoucher(Long voucherId, Long userId);
}
