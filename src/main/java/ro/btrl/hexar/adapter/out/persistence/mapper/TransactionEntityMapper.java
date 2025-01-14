package ro.btrl.hexar.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.btrl.hexar.adapter.out.persistence.entity.TransactionEntity;
import ro.btrl.hexar.domain.model.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionEntityMapper {

    @Mapping(target = "processed", ignore = true)
    TransactionEntity toEntity(Transaction transaction);

    Transaction toModel(TransactionEntity transactionEntity);

}
