package ro.btrl.hexar.domain.port.in;

import ro.btrl.hexar.exception.InsufficientFundsException;

public interface TransferService {

    void transfer(TransferDetails transferDetails) throws InsufficientFundsException;

}
