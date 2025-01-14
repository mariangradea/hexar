package ro.btrl.hexar.adapter.out.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ro.btrl.hexar.adapter.out.persistence.entity.AccountEntity;
import ro.btrl.hexar.domain.model.Account;

@Mapper(componentModel = "spring")
public interface AccountEntityMapper {

    @Mapping(target = "transactions", ignore = true)
    Account toModel(AccountEntity accountEntity);

}
