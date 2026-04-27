package org.example.debugtransfermoney.exception;

import lombok.extern.slf4j.Slf4j;
import org.example.debugtransfermoney.dto.TransferResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<TransferResult> handleInsufficientFunds(InsufficientFundsException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(TransferResult.failed(e.getMessage()));
    }

    @ExceptionHandler(NotificationException.class)
    public ResponseEntity<TransferResult> handleNotification(NotificationException e) {
        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(TransferResult.failed("Notification error: " + e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TransferResult> handleGeneric(Exception e) {
        log.error("Unexpected error", e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(TransferResult.failed("Internal error"));
    }
}
