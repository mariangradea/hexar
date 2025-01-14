package ro.btrl.hexar.domain.port.out;

import jakarta.validation.constraints.NotNull;
import ro.btrl.hexar.domain.model.Account;

public interface LoadAccountPort {

    Account loadAccount(@NotNull Long accountId);

}
