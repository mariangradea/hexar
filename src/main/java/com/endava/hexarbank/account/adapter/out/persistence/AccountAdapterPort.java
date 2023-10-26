package com.endava.hexarbank.account.adapter.out.persistence;

import com.endava.hexarbank.account.application.domain.model.Account;
import com.endava.hexarbank.account.application.port.out.LoadAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class AccountAdapterPort implements LoadAccountPort {

    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public Account loadAccount(Long accountId) {

        final var account = accountMapper.toModel(accountRepository.getReferenceById(accountId));
        final var transactions = transactionRepository.getAllTransactionsForAccountId(accountId).stream()
                .map(transactionMapper::toModel)
                .toList();
        account.setTransactions(transactions);
        return account;
    }

}
