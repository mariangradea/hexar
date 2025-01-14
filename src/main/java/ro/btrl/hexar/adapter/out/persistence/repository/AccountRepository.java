package ro.btrl.hexar.adapter.out.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.btrl.hexar.adapter.out.persistence.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
}