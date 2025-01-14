package ro.btrl.hexar.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import ro.btrl.hexar.adapter.out.persistence.mapper.AccountEntityMapperImpl;
import ro.btrl.hexar.adapter.out.persistence.mapper.TransactionEntityMapperImpl;
import ro.btrl.hexar.domain.model.Account;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({AccountAdapter.class, AccountEntityMapperImpl.class, TransactionEntityMapperImpl.class})
class AccountAdapterTest {

    @Autowired
    private AccountAdapter accountAdapter;

    @Test
    @Sql("data.sql")
    void loadAccount() {
        Account account = accountAdapter.loadAccount(1001L);

        assertThat(account.getTransactions()).hasSize(2);
        assertThat(account.calculateBalance()).isEqualTo(95L);
    }
}
