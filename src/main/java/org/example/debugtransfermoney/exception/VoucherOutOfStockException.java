package org.example.debugtransfermoney.exception;

public class VoucherOutOfStockException extends RuntimeException {
    public VoucherOutOfStockException(String message) {
        super(message);
    }
}
