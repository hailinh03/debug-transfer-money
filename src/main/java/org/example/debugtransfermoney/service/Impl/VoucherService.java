package org.example.debugtransfermoney.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.debugtransfermoney.dto.RedeemResult;
import org.example.debugtransfermoney.entity.Voucher;
import org.example.debugtransfermoney.entity.VoucherRedemption;
import org.example.debugtransfermoney.exception.VoucherOutOfStockException;
import org.example.debugtransfermoney.repository.VoucherRedemptionRepository;
import org.example.debugtransfermoney.repository.VoucherRepository;
import org.example.debugtransfermoney.service.IVoucherService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VoucherService implements IVoucherService {


    private final VoucherRepository voucherRepository;
    private final VoucherRedemptionRepository redemptionRepository;


    /*
     * Case 3: Flash sale voucher - 100 user cùng click "Nhận voucher" khi chỉ còn 10 cái
     * -> Bug: hệ thống phát ra 100 voucher thay vì 10 (oversell)
     *    -> remainingQuantity bị âm
     *    -> số lượng redemption > totalQuantity
     * -> Reproduce bằng JMeter với 100 concurrent threads
     */
    @Override
    public RedeemResult redeemVoucher(Long voucherId, Long userId) {


        Voucher voucher = voucherRepository.findById(voucherId)
                .orElseThrow(() -> new IllegalArgumentException("Voucher not found"));


        if (voucher.getRemainingQuantity() <= 0) {
            throw new VoucherOutOfStockException(
                    "Voucher " + voucher.getCode() + " is out of stock");
        }


        voucher.setRemainingQuantity(voucher.getRemainingQuantity() - 1);
        voucherRepository.save(voucher);


//        int updated = voucherRepository.decrementIfAvailable(voucherId);
//
//        if(updated == 0){
//            throw new VoucherOutOfStockException("Voucher is out of stock");
//        }


        VoucherRedemption redemption = new VoucherRedemption();
        redemption.setVoucherId(voucherId);
        redemption.setUserId(userId);
        redemption.setRedeemedAt(LocalDateTime.now());
        redemptionRepository.save(redemption);

  //      Voucher voucher = voucherRepository.findById(voucherId).orElseThrow();
        return RedeemResult.success(voucher.getRemainingQuantity());
    }


}
