package com.endava.hexarbank.account.adapter.in.web;

import com.endava.hexarbank.account.application.port.in.TransferCommand;
import com.endava.hexarbank.account.application.port.in.TransferUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AccountController {

    private final TransferUseCase transferUseCase;

    @PostMapping(path = "/accounts/transfer/{sourceAccountId}/{targetAccountId}/{amount}")
    void transfer(@PathVariable("sourceAccountId") Long sourceAccountId,
                  @PathVariable("targetAccountId") Long targetAccountId,
                  @PathVariable("amount") Long amount) {

        final var command = new TransferCommand(sourceAccountId, targetAccountId, amount);
        transferUseCase.transfer(command);
    }

}
