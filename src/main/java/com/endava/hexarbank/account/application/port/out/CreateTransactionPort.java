package com.endava.hexarbank.account.application.port.out;

import com.endava.hexarbank.account.application.domain.model.Transaction;

public interface CreateTransactionPort {

    void createTransaction(Transaction transaction);

}
