package org.example.debugtransfermoney.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.debugtransfermoney.dto.TransferResult;
import org.example.debugtransfermoney.exception.InsufficientFundsException;
import org.example.debugtransfermoney.exception.NotificationException;
import org.example.debugtransfermoney.service.ITransferService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferService implements ITransferService {

    private final AuditService auditService;
    private final TransferExecutorService transferExecutorService;
    private final NotificationService notificationService;


  /*
  *
  *  Case 1: Khi chuyển tiền đúng có audit log,Nhưng khi tui chuyển tiền lớn hơn balance tôi đang có
  *  -> Bug: thay vì nhận Audit Log là FAILED  thì lại bị 500?
  *
  * */

    @Override
    @Transactional
    public TransferResult transfer(Long fromId, Long toId, BigDecimal amount) {
        try {
            transferExecutorService.execute(fromId, toId, amount);
            notificationService.sendTransferNotification(fromId, toId, amount);
            auditService.logSuccess(fromId, toId, amount);
            return TransferResult.success();
        } catch (InsufficientFundsException e) {
            auditService.logFailure(fromId, toId, amount, e);
            return TransferResult.failed(e.getMessage());
        } catch (NotificationException e) {
            auditService.logFailure(fromId, toId, amount, e);
            return TransferResult.failed("Notification failed: " + e.getMessage());
        }
    }

}