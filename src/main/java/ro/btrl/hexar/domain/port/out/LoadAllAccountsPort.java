package ro.btrl.hexar.domain.port.out;

import ro.btrl.hexar.domain.model.Account;

import java.util.List;

public interface LoadAllAccountsPort {

    List<Account> loadAllAccounts();

}
