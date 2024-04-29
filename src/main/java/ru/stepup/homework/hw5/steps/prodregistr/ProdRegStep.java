package ru.stepup.homework.hw5.steps.prodregistr;

import ru.stepup.homework.hw5.dto.ProductDto;

@FunctionalInterface
public interface ProdRegStep<T> {
    void start(ProductDto productDto);
}
