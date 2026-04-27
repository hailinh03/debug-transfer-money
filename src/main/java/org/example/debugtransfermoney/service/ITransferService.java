package org.example.debugtransfermoney.service;

import org.example.debugtransfermoney.dto.TransferResult;
import org.example.debugtransfermoney.exception.NotificationException;

import java.math.BigDecimal;

public interface ITransferService {
    TransferResult transfer(Long fromId, Long toId, BigDecimal amount);
}
