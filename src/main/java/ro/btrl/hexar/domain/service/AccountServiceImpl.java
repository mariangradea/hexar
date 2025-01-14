package ro.btrl.hexar.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.btrl.hexar.domain.model.Account;
import ro.btrl.hexar.domain.port.in.AccountService;
import ro.btrl.hexar.domain.port.out.LoadAccountPort;
import ro.btrl.hexar.domain.port.out.LoadAllAccountsPort;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final LoadAccountPort loadAccountPort;
    private final LoadAllAccountsPort loadAllAccountsPort;

    @Override
    public Account getAccountById(Long id) {
        return loadAccountPort.loadAccount(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return loadAllAccountsPort.loadAllAccounts();
    }

}
