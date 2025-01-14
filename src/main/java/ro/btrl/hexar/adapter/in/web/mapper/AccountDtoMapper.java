package ro.btrl.hexar.adapter.in.web.mapper;

import org.mapstruct.Mapper;
import ro.btrl.hexar.adapter.in.web.dto.AccountDto;
import ro.btrl.hexar.domain.model.Account;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {

    AccountDto toDto(Account account);

}
