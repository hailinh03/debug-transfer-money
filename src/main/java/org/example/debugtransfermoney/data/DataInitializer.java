package org.example.debugtransfermoney.data;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.debugtransfermoney.entity.Account;
import org.example.debugtransfermoney.entity.Voucher;
import org.example.debugtransfermoney.repository.AccountRepository;
import org.example.debugtransfermoney.repository.VoucherRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class DataInitializer {

    private final AccountRepository accountRepository;
    private final VoucherRepository voucherRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("-Init data-");

        // Account
        if (accountRepository.count() == 0) {
            accountRepository.saveAll(List.of(
                    Account.builder().owner("Alice").balance(new BigDecimal("180.00")).build(),
                    Account.builder().owner("Bob").balance(new BigDecimal("550.00")).build(),
                    Account.builder().owner("Charlie").balance(new BigDecimal("600.00")).build(),
                    Account.builder().owner("Jack").balance(new BigDecimal("700.00")).build(),
                    Account.builder().owner("Alex").balance(new BigDecimal("1000.00")).build(),
                    Account.builder().owner("Messi").balance(new BigDecimal("2500.00")).build(),
                    Account.builder().owner("Yasuo").balance(new BigDecimal("2700.00")).build()
            ));
        } else {
            log.info("-Skip init account data-");
        }

        // Voucher
        if (voucherRepository.count() == 0) {
            voucherRepository.saveAll(List.of(
                    Voucher.builder().code("BLACKFRIDAY").remainingQuantity(10).totalQuantity(10).build(),
                    Voucher.builder().code("TET").remainingQuantity(20).totalQuantity(20).build(),
                    Voucher.builder().code("TRUNGTHU").remainingQuantity(30).totalQuantity(30).build(),
                    Voucher.builder().code("SUMMER").remainingQuantity(40).totalQuantity(40).build(),
                    Voucher.builder().code("SINHNHAT").remainingQuantity(50).totalQuantity(50).build(),
                    Voucher.builder().code("HOIMUASAM").remainingQuantity(100).totalQuantity(100).build()
                    )
            );
        } else {
            log.info("-Skip init voucher data-");
        }

        log.info("Done!");
    }
}
