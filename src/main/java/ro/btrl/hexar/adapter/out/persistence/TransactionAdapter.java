package ro.btrl.hexar.adapter.out.persistence;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.btrl.hexar.adapter.out.persistence.mapper.TransactionEntityMapper;
import ro.btrl.hexar.adapter.out.persistence.repository.TransactionRepository;
import ro.btrl.hexar.domain.model.Transaction;
import ro.btrl.hexar.domain.port.out.CreateTransactionPort;

@Component
@RequiredArgsConstructor
class TransactionAdapter implements CreateTransactionPort {

    private final TransactionEntityMapper mapper;
    private final TransactionRepository repository;

    @Override
    public void createTransaction(Transaction transaction) {
        repository.save(mapper.toEntity(transaction));
    }

}
