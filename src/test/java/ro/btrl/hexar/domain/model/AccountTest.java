package ro.btrl.hexar.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @Test
    void calculateBalanceSuccess() {
        Account account = new Account();
        Transaction transactionOut = new Transaction(1L, 2L, 10L, LocalDateTime.now());
        Transaction transactionIn = new Transaction(2L, 1L, 10L, LocalDateTime.now());
        account.setId(1L);
        account.setBalance(20L);
        account.setTransactions(List.of(transactionOut, transactionIn));

        Long balance = account.calculateBalance();

        assertThat(balance).isEqualTo(20L);
    }
}
