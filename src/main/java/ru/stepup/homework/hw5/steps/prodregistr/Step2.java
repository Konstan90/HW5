package ru.stepup.homework.hw5.steps.prodregistr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.repositories.ProductRegisterRepository;

@Component
@Order(2)
public class Step2 implements ProdRegStep {
    @Autowired
    private ProductRegisterRepository prodRegRep;
    private boolean findRepeat(ProductDto productDto){
        var ProductsByInstanceId = prodRegRep.findAllByProductId(productDto.instanceId());
        return ProductsByInstanceId.stream().anyMatch(x->x.getType().equals(productDto.registryTypeCode()));
    }
    @Override
    public void start(ProductDto productDto) {
        // Шаг 2 Проверка таблицы ПР (таблица tpp_product_register) на дубли
        if (findRepeat(productDto)) {
            String error = String.format("Параметр registryTypeCode тип регистра %s" +
                    " уже существует для ЭП с ИД  %d.",productDto.registryTypeCode(),productDto.instanceId());
            SException exp = new SException(error, new Throwable(""));
            exp.setHttpMethodType("Bad_Request");
            throw exp;
        }
    }
}
