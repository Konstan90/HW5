package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.ProductClass;

import java.util.List;

@Repository
public interface ProductClassRepository extends CrudRepository<ProductClass, Long> {
    ProductClass findFirstByValue(String value);
    List<ProductClass> findAllByValue(String value);
    ProductClass findProductClassByInternalId(Long internalId);
}
