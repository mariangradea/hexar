package ro.btrl.hexar.adapter.out.persistence;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.btrl.hexar.adapter.out.persistence.mapper.AccountEntityMapper;
import ro.btrl.hexar.adapter.out.persistence.mapper.TransactionEntityMapper;
import ro.btrl.hexar.adapter.out.persistence.repository.AccountRepository;
import ro.btrl.hexar.adapter.out.persistence.repository.TransactionRepository;
import ro.btrl.hexar.domain.model.Account;
import ro.btrl.hexar.domain.port.out.LoadAccountPort;
import ro.btrl.hexar.domain.port.out.LoadAllAccountsPort;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class AccountAdapter implements LoadAccountPort, LoadAllAccountsPort {

    private final AccountEntityMapper accountEntityMapper;
    private final TransactionEntityMapper transactionEntityMapper;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Account loadAccount(Long accountId) {

        final var account = accountEntityMapper.toModel(accountRepository.getReferenceById(accountId));
        final var transactions = transactionRepository.getAllTransactionsForAccountId(accountId).stream()
                .map(transactionEntityMapper::toModel)
                .toList();
        account.setTransactions(transactions);
        return account;
    }

    @Override
    public List<Account> loadAllAccounts() {
        return accountRepository.findAll().stream().map(accountEntityMapper::toModel).collect(Collectors.toList());
    }

}
