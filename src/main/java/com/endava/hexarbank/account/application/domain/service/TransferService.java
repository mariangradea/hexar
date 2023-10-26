package com.endava.hexarbank.account.application.domain.service;

import com.endava.hexarbank.account.application.domain.model.Account;
import com.endava.hexarbank.account.application.domain.model.Transaction;
import com.endava.hexarbank.account.application.port.in.TransferCommand;
import com.endava.hexarbank.account.application.port.in.TransferUseCase;
import com.endava.hexarbank.account.application.port.out.CreateTransactionPort;
import com.endava.hexarbank.account.application.port.out.LoadAccountPort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class TransferService implements TransferUseCase {

    private final LoadAccountPort loadAccountPort;
    private final CreateTransactionPort createTransactionPort;

    @Override
    public void transfer(TransferCommand transferCommand) {

        log.debug("Received transfer command: {}", transferCommand);
        Account sourceAccount = loadAccountPort.loadAccount(transferCommand.getSourceAccountId());
        Account targetAccount = loadAccountPort.loadAccount(transferCommand.getTargetAccountId());
        if (sourceAccount.calculateBalance() - transferCommand.getAmount() < 0) {
            throw new RuntimeException("Insufficient funds");
        }
        final Transaction transaction = new Transaction(
                sourceAccount.getId(),
                targetAccount.getId(),
                transferCommand.getAmount(),
                LocalDateTime.now()
        );
        createTransactionPort.createTransaction(transaction);
    }

}
