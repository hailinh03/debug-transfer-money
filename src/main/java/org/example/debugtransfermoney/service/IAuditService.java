package org.example.debugtransfermoney.service;

import java.math.BigDecimal;

public interface IAuditService {
    void logSuccess(Long from, Long to, BigDecimal amount);
    void logFailure(Long from, Long to, BigDecimal amount, Exception e);
}
