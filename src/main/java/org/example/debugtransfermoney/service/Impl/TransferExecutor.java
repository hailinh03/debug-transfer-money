package org.example.debugtransfermoney.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.debugtransfermoney.entity.Account;
import org.example.debugtransfermoney.exception.FeeException;
import org.example.debugtransfermoney.exception.InsufficientFundsException;
import org.example.debugtransfermoney.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferExecutor {

    private final AccountRepository repo;
    @Transactional
    public void execute(Long fromId, Long toId, BigDecimal amount) {

        Account from = repo.findById(fromId).orElseThrow();
        Account to = repo.findById(toId).orElseThrow();

        if (from.getBalance().compareTo(amount) <= 0) {
            throw new InsufficientFundsException("Don't have enough balance");
        }

        BigDecimal fromBalance = from.getBalance();
        BigDecimal toBalance = to.getBalance();

        fromBalance.subtract(amount);
        toBalance = toBalance.add(amount);

        from.setBalance(fromBalance);
        to.setBalance(toBalance);
    }














//    @Transactional
//    public void execute(Long fromId, Long toId, BigDecimal amount) {
//        Account from = repo.findById(fromId).orElseThrow();
//        Account to = repo.findById(toId).orElseThrow();
//
//        if (from.getBalance().compareTo(amount) < 0) {
//            throw new InsufficientFundsException("Don't have enough balance");
//        }
//
//        from.setBalance(from.getBalance().subtract(amount));
//        to.setBalance(to.getBalance().add(amount));
//    }

}
