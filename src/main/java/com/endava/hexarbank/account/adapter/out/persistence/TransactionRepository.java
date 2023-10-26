package com.endava.hexarbank.account.adapter.out.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    @Query("""
             SELECT t FROM TransactionEntity t
             WHERE t.sourceAccountId = :accountId
             OR t.targetAccountId = :accountId
            """)
    List<TransactionEntity> getAllTransactionsForAccountId(Long accountId);

}
