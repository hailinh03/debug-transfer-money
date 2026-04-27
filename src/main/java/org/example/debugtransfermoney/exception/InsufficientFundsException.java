package org.example.debugtransfermoney.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InsufficientFundsException extends RuntimeException{
    private Long accountId;
    private BigDecimal currentBalance;
    private BigDecimal requestedAmount;

    public InsufficientFundsException(String message) {
        super(message);
    }

}
