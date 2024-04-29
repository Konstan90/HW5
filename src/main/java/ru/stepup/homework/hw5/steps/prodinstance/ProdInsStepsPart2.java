package ru.stepup.homework.hw5.steps.prodinstance;

import ru.stepup.homework.hw5.dto.ProductInstanceDTO;

import java.util.List;

@FunctionalInterface
public interface ProdInsStepsPart2<T> {
    List start(ProductInstanceDTO prodInsDTO, Integer productId);
}
