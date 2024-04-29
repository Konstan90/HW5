package ru.stepup.homework.hw5.steps.prodregistr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.repositories.ProductRegisterTypeRepository;

@Component
@Order(3)
public class Step3 implements ProdRegStep {

    @Autowired
    private ProductRegisterTypeRepository prodRegType;
    private boolean findType(ProductDto productDto){
        var ProductRegType = prodRegType.findFirstByValue(productDto.registryTypeCode());
        return ProductRegType != null;
    }
    @Override
    public void start(ProductDto productDto) {
        // Шаг 3 Взять значение из Request.Body.registryTypeCode и найти соответствующие ему записи в tpp_ref_product_register_type.value.
        if (!findType(productDto)) {
            String error = String.format("Код продукта  %s" +
                    " значение %s" +
                    " не найдено в Каталоге продуктов tpp_ref_product_register_type" +
                    " для данного типа Регистра",productDto.instanceId(), productDto.registryTypeCode());
            SException exp = new SException(error, new Throwable(""));
            exp.setHttpMethodType("Not_Found");
            throw exp;
        }
    }
}
