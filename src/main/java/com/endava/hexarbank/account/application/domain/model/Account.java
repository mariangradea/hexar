package com.endava.hexarbank.account.application.domain.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Getter
@Setter
public class Account {

    @Getter(onMethod_ = {@JsonGetter("Errors")})
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
