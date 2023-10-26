package com.endava.hexarbank.account.application.domain.service;

import com.endava.hexarbank.account.application.domain.model.Account;
import com.endava.hexarbank.account.application.domain.model.Transaction;
import com.endava.hexarbank.account.application.port.in.TransferCommand;
import com.endava.hexarbank.account.application.port.out.CreateTransactionPort;
import com.endava.hexarbank.account.application.port.out.LoadAccountPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferServiceTest {

    @Mock
    private LoadAccountPort loadAccountPort;
    @Mock
    private CreateTransactionPort createTransactionPort;
    @InjectMocks
    private TransferService transferService;

    @Test
    void transferSuccess() {
        when(loadAccountPort.loadAccount(1L)).thenReturn(createAccount(1L));
        when(loadAccountPort.loadAccount(2L)).thenReturn(createAccount(2L));
        doNothing().when(createTransactionPort).createTransaction(any(Transaction.class));
        TransferCommand transferCommand = new TransferCommand(1L, 2L, 10L);

        transferService.transfer(transferCommand);

        verifyNoMoreInteractions(createTransactionPort);
    }

    Account createAccount(Long id) {
        Account account = new Account();
        account.setId(id);
        account.setBalance(20L);
        return account;
    }
}