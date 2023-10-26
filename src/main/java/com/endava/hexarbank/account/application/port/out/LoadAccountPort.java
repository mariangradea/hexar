package com.endava.hexarbank.account.application.port.out;

import com.endava.hexarbank.account.application.domain.model.Account;

public interface LoadAccountPort {

    Account loadAccount(Long accountId);

}
