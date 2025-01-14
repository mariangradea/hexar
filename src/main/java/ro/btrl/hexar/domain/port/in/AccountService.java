package ro.btrl.hexar.domain.port.in;

import jakarta.validation.constraints.NotNull;
import ro.btrl.hexar.domain.model.Account;

import java.util.List;

public interface AccountService {

    Account getAccountById(@NotNull Long id);

    List<Account> getAllAccounts();

}
