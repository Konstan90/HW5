package ru.stepup.homework.hw5.steps.prodregistr;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductDto;

@Component
@Order(1)
public class Step1 implements ProdRegStep{
    @Override
    public void start(ProductDto productDto) {
        // Шаг 1 Проверка на обязательность
        if (productDto.instanceId() == 0) {
            String error = "Идентификатор экземпляра продукта <InstanceId>  не заполнен";
            SException exp = new SException(error, new Throwable(""));
            exp.setHttpMethodType("Bad_Request");
            throw exp;
        }
    }
}
