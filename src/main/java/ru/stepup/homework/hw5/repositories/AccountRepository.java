package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.Account;

import java.util.List;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAccountNumbersByAccountPoolIdOrderById(Long accountPoolId);

    Account findFirstByAccountPoolIdOrderById(Long accountPoolId);
}
