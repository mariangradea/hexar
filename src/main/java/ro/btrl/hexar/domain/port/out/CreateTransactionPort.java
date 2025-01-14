package ro.btrl.hexar.domain.port.out;

import jakarta.validation.constraints.NotNull;
import ro.btrl.hexar.domain.model.Transaction;

public interface CreateTransactionPort {

    void createTransaction(@NotNull Transaction transaction);

}
