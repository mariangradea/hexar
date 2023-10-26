package com.endava.hexarbank.account.adapter.out.persistence;

import com.endava.hexarbank.account.application.domain.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "transactions", ignore = true)
    Account toModel(AccountEntity accountEntity);

}
