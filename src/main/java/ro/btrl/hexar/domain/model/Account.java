package ro.btrl.hexar.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Getter
@Setter
public class Account {

    private Long id;
    private Long balance;
    private List<Transaction> transactions;

    public Long calculateBalance() {
        if (isEmpty(transactions)) {
            return balance;
        }
        final var depositBalance = transactions.stream()
                .filter(t -> t.getTargetAccountId().equals(id))
                .map(Transaction::getAmount)
                .reduce(0L, Long::sum);
        final var withdrawalBalance = transactions.stream()
                .filter(t -> t.getSourceAccountId().equals(id))
                .map(Transaction::getAmount)
                .reduce(0L, Long::sum);
        return balance + depositBalance - withdrawalBalance;
    }

}
