package ro.btrl.hexar.adapter.in.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.btrl.hexar.adapter.in.web.dto.AccountDto;
import ro.btrl.hexar.adapter.in.web.mapper.AccountDtoMapper;
import ro.btrl.hexar.domain.port.in.AccountService;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Accounts", description = "Accounts management")
@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountDtoMapper accountDtoMapper;

    @Operation(summary = "Retrieve account information")
    @GetMapping(path = "{id}")
    AccountDto getAccountById(@PathVariable("id") Long id) {
        final var account = accountService.getAccountById(id);
        return accountDtoMapper.toDto(account);
    }

    @Operation(summary = "Retrieve all accounts")
    @GetMapping
    List<AccountDto> getAccounts() {
        final var accounts = accountService.getAllAccounts();
        return accounts.stream().map(accountDtoMapper::toDto).collect(Collectors.toList());
    }

}
