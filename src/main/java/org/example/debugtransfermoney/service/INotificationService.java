package org.example.debugtransfermoney.service;

import org.example.debugtransfermoney.exception.NotificationException;

import java.math.BigDecimal;

public interface INotificationService {
    void sendTransferNotification(Long fromId, Long toId, BigDecimal amount) throws NotificationException;
}
