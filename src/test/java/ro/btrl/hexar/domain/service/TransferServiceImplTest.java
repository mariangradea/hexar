package ro.btrl.hexar.domain.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.btrl.hexar.domain.model.Account;
import ro.btrl.hexar.domain.model.Transaction;
import ro.btrl.hexar.domain.port.in.TransferDetails;
import ro.btrl.hexar.domain.port.out.CreateTransactionPort;
import ro.btrl.hexar.domain.port.out.LoadAccountPort;
import ro.btrl.hexar.exception.InsufficientFundsException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransferServiceImplTest {

    @Mock
    private LoadAccountPort loadAccountPort;
    @Mock
    private CreateTransactionPort createTransactionPort;
    @InjectMocks
    private TransferServiceImpl transferService;

    @Test
    void transferSuccess() throws InsufficientFundsException {
        when(loadAccountPort.loadAccount(1L)).thenReturn(createAccount(1L));
        when(loadAccountPort.loadAccount(2L)).thenReturn(createAccount(2L));
        doNothing().when(createTransactionPort).createTransaction(any(Transaction.class));
        var transferCommand = new TransferDetails(1L, 2L, 10L);

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
