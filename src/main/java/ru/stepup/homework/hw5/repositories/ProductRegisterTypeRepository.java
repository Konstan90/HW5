package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.ProductRegisterType;

import java.util.List;

@Repository
public interface ProductRegisterTypeRepository extends CrudRepository<ProductRegisterType, Long> {
    List<ProductRegisterType> findAllByValue(String value);
    ProductRegisterType findFirstByValue(String value);
    List<ProductRegisterType> findProductRegisterTypesByProductClassCodeAndAccountType(String productClassCode, String accountType);
}
