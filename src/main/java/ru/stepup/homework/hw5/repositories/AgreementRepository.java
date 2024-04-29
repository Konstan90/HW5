package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.Agreement;

import java.util.List;

@Repository
public interface AgreementRepository extends CrudRepository<Agreement, Long> {
    List<Agreement> findAgreementsByNumber(String number);
    Agreement findFirstByNumber(String number);
}
