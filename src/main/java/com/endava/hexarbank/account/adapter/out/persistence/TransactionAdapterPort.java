package com.endava.hexarbank.account.adapter.out.persistence;

import com.endava.hexarbank.account.application.domain.model.Transaction;
import com.endava.hexarbank.account.application.port.out.CreateTransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class TransactionAdapterPort implements CreateTransactionPort {

    private final TransactionMapper mapper;
    private final TransactionRepository repository;

    @Override
    public void createTransaction(Transaction transaction) {

        repository.save(mapper.toEntity(transaction));
    }

}
