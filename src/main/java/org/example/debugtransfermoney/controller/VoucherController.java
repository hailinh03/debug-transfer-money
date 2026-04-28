package org.example.debugtransfermoney.controller;

import lombok.RequiredArgsConstructor;
import org.example.debugtransfermoney.dto.RedeemRequest;
import org.example.debugtransfermoney.dto.RedeemResult;
import org.example.debugtransfermoney.service.IVoucherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vouchers")
@RequiredArgsConstructor
public class VoucherController {

    private final IVoucherService ivoucherService;

    @PostMapping("/redeem")
    public RedeemResult redeem(@RequestBody RedeemRequest redeemRequest) {
        return ivoucherService.redeemVoucher(redeemRequest.getVoucherId(),redeemRequest.getUserId());
    }
}