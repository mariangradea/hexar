package com.endava.hexarbank.account.application.port.in;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.ToString;

import static com.endava.hexarbank.common.validation.Validation.validate;

@Getter
@ToString
public class TransferCommand {

    @NotNull
    private final Long sourceAccountId;

    @NotNull
    private final Long targetAccountId;

    @NotNull
    @PositiveOrZero
    private final Long amount;

    public TransferCommand(Long sourceAccountId, Long targetAccountId, Long amount) {
        if (sourceAccountId.equals(targetAccountId)) {
            throw new RuntimeException("Cannot make transfer to self account");
        }
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;

        validate(this);
    }
}
