package org.example.debugtransfermoney.service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.example.debugtransfermoney.exception.NotificationException;
import org.example.debugtransfermoney.service.INotificationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class NotificationService implements INotificationService {

    @Override
    public void sendTransferNotification(Long fromId, Long toId, BigDecimal amount){
      try{
          log.info("Notification sent: Account {} → Account {}, amount: {}", fromId, toId, amount);
      }catch(NotificationException e){
          throw new NotificationException(e.getMessage());
      }
    }
}
