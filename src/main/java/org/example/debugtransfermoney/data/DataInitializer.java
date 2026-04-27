package org.example.debugtransfermoney.data;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.debugtransfermoney.entity.Account;
import org.example.debugtransfermoney.repository.AccountRepository;
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


    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("-Init data-");

        if (accountRepository.count() > 0) {
            log.info("-Skip init data due to already existing data-");
            return;
        }

        accountRepository.saveAll(List.of(
                Account.builder().owner("Alice").balance(new BigDecimal("180.00")).build(),
                Account.builder().owner("Bob").balance(new BigDecimal("550.00")).build(),
                Account.builder().owner("Charlie").balance(new BigDecimal("600.00")).build(),
                Account.builder().owner("Jack").balance(new BigDecimal("700.00")).build(),
                Account.builder().owner("Alex").balance(new BigDecimal("1000.00")).build(),
                Account.builder().owner("Messi").balance(new BigDecimal("2500.00")).build(),
                Account.builder().owner("Yasuo").balance(new BigDecimal("2700.00")).build()
        ));


        log.info("Done!");
    }
}
