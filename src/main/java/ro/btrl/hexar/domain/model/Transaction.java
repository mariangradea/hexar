package ro.btrl.hexar.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private Long id;
    private Long sourceAccountId;
    private Long targetAccountId;
    private Long amount;
    private LocalDateTime timestamp;

    public Transaction(Long sourceAccountId, Long targetAccountId, Long amount, LocalDateTime timestamp) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

}
