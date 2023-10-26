package com.endava.hexarbank.account.adapter.out.persistence;

import com.endava.hexarbank.account.application.domain.model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionEntity toEntity(Transaction transaction);

    Transaction toModel(TransactionEntity transactionEntity);

}
