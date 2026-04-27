package org.example.debugtransfermoney.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.debugtransfermoney.entity.AuditLog;
import org.example.debugtransfermoney.repository.AuditRepository;
import org.example.debugtransfermoney.service.IAuditService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AuditService implements IAuditService {

    private final AuditRepository auditRepo;
    public void logSuccess(Long from, Long to, BigDecimal amount) {
        AuditLog log = AuditLog.builder()
                .status("SUCCESS")
                .fromAccountId(from)
                .toAccountId(to)
                .amount(amount)
                .build();
        auditRepo.save(log);
    }
    public void logFailure(Long from, Long to, BigDecimal amount, Exception e) {
        AuditLog log = AuditLog.builder()
                .status("FAILED")
                .fromAccountId(from)
                .toAccountId(to)
                .amount(amount)
                .errorMessage(e != null ? e.getMessage() : "Unknown error")
                .build();
        auditRepo.save(log);
    }

}
