package ro.btrl.hexar.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.btrl.hexar.adapter.out.persistence.entity.TransactionEntity;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query("""
             SELECT t FROM TransactionEntity t
             WHERE t.sourceAccountId = :accountId
             OR t.targetAccountId = :accountId
             AND t.processed = false
            """)
    List<TransactionEntity> getAllTransactionsForAccountId(Long accountId);

}