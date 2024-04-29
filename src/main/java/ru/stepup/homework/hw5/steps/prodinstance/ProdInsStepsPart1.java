package ru.stepup.homework.hw5.steps.prodinstance;

import ru.stepup.homework.hw5.dto.ProductInstanceDTO;

@FunctionalInterface
public interface ProdInsStepsPart1<T> {
    Integer start(ProductInstanceDTO prodInsDTO);
}
