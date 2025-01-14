package ro.btrl.hexar.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.btrl.hexar.domain.model.Account;
import ro.btrl.hexar.domain.model.Transaction;
import ro.btrl.hexar.domain.port.in.TransferDetails;
import ro.btrl.hexar.domain.port.in.TransferService;
import ro.btrl.hexar.domain.port.out.CreateTransactionPort;
import ro.btrl.hexar.domain.port.out.LoadAccountPort;
import ro.btrl.hexar.exception.InsufficientFundsException;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class TransferServiceImpl implements TransferService {

    private final LoadAccountPort loadAccountPort;
    private final CreateTransactionPort createTransactionPort;

    @Override
    public void transfer(TransferDetails transferDetails) throws InsufficientFundsException {

        log.debug("Executing transfer: {}", transferDetails);
        Account sourceAccount = loadAccountPort.loadAccount(transferDetails.getSourceAccountId());
        Account targetAccount = loadAccountPort.loadAccount(transferDetails.getTargetAccountId());
        if (sourceAccount.calculateBalance() - transferDetails.getAmount() < 0) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        final Transaction transaction = new Transaction(
                sourceAccount.getId(),
                targetAccount.getId(),
                transferDetails.getAmount(),
                LocalDateTime.now()
        );
        createTransactionPort.createTransaction(transaction);
    }

}
