package org.example.debugtransfermoney.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RedeemResult {
    private boolean success;
    private String message;
    private Integer remaining;


    public static RedeemResult success(Integer remaining) {
        return new RedeemResult(true, "Voucher redeemed successfully", remaining);
    }

    public static RedeemResult failed(String message) {
        return new RedeemResult(false, message, null);
    }

}
