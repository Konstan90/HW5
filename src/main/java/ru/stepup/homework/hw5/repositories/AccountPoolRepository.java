package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.AccountPool;

@Repository
public interface AccountPoolRepository extends CrudRepository<AccountPool, Long> {
    AccountPool findAccountPoolByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegisterTypeCode(
            String branchCode, String currencyCode, String mdmCode, String priorityCode, String registerTypeCode
    );
}
