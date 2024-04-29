package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.ProductRegister;
import ru.stepup.homework.hw5.entities.ProductRegisterType;

import java.util.List;

@Repository
public interface ProductRegisterRepository extends CrudRepository<ProductRegister, Long> {
    List<ProductRegister> findAllByProductId(Integer productId);
}
