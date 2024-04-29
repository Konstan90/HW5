package ru.stepup.homework.hw5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.stepup.homework.hw5.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByNumber(String number);
    Product findFirstById(Integer id);
    void deleteByNumber(String number);
}
