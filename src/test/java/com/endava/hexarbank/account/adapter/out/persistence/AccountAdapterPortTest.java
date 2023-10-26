package com.endava.hexarbank.account.adapter.out.persistence;

import com.endava.hexarbank.account.application.domain.model.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({AccountAdapterPort.class, AccountMapperImpl.class, TransactionMapperImpl.class})
class AccountAdapterPortTest {

    @Autowired
    private AccountAdapterPort accountAdapterPort;

    @Test
    @Sql("data.sql")
    void loadAccount() {
        Account account = accountAdapterPort.loadAccount(1001L);

        assertThat(account.getTransactions()).hasSize(2);
        assertThat(account.calculateBalance()).isEqualTo(95L);
    }
}