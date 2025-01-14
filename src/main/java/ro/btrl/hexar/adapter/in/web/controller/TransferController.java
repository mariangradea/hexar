package ro.btrl.hexar.adapter.in.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.btrl.hexar.domain.port.in.TransferDetails;
import ro.btrl.hexar.domain.port.in.TransferService;
import ro.btrl.hexar.exception.InsufficientFundsException;

@Tag(name = "Transfers", description = "Transfers management")
@RestController
@RequestMapping("transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @Operation(summary = "Execute a transfer between two accounts")
    @PostMapping(path = "execute/{sourceAccountId}/{targetAccountId}/{amount}")
    void transfer(@PathVariable("sourceAccountId") Long sourceAccountId,
                  @PathVariable("targetAccountId") Long targetAccountId,
                  @PathVariable("amount") Long amount) throws InsufficientFundsException {

        final var transferDetails =
                new TransferDetails(sourceAccountId, targetAccountId, amount);
        transferService.transfer(transferDetails);
    }

}
