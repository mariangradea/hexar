package ro.btrl.hexar.adapter.in.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Schema(description = "Account DTO.", type = "object")
@Data
@RequiredArgsConstructor
public class AccountDto {

    @Schema(description = "Account identifier", type = "Long", example = "1001")
    private final Long id;

    @Schema(description = "Account balance", type = "Long", example = "1605")
    private final Long balance;

}
