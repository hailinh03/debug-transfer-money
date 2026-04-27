package org.example.debugtransfermoney.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferResult {

    private boolean success;
    private String message;
    private String transactionId;
    private BigDecimal amount;
    private LocalDateTime timestamp;

    private TransferResult(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public static TransferResult success() {
        TransferResult result = new TransferResult(true, "Transfer Successful");
        result.transactionId = UUID.randomUUID().toString();
        return result;
    }
    public static TransferResult success(String message) {
        TransferResult result = new TransferResult(true, message);
        result.transactionId = UUID.randomUUID().toString();
        return result;
    }
    public static TransferResult failed(String reason) {
        return new TransferResult(false, reason);
    }
}
