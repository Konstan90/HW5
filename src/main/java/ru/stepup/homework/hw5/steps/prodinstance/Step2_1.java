package ru.stepup.homework.hw5.steps.prodinstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class Step2_1 implements ProdInsStepsPart2<ProductInstanceDTO> {
    @Autowired
    ProductRepository productRepo;
    @Override
    public List start(ProductInstanceDTO prodInsDTO, Integer productId) {
        //Шаг 2.1
        //Проверка таблицы ЭП (tpp_product) на существование ЭП
        var product = productRepo.findFirstById(productId);
        if (product == null) {
            String error = String.format("Экземпляр продукта с параметром instanceId %s не найден",
                    prodInsDTO.instanceId());
            SException exp = new SException(error, new Throwable(""));
            exp.setHttpMethodType("Not_Found");
            throw exp;
        }

        return new ArrayList<>();
    }
}
