package ru.stepup.homework.hw5.steps.prodinstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.repositories.ProductRepository;

@Component
@Order(1)
public class Step1_1 implements ProdInsStepsPart1<ProductInstanceDTO>{
    @Autowired
    ProductRepository productRepo;
    @Override
    public Integer start(ProductInstanceDTO prodInsDTO) {
        //Шаг 1.1
        //Проверка таблицы ЭП (tpp_product) на дубли.
        if(prodInsDTO.instanceId() != null ) return Integer.valueOf(prodInsDTO.instanceId()); //Пропускаем этот шаг, если создавать экземпляр не нужно
        var doubles = productRepo.findAllByNumber(prodInsDTO.contractNumber());
        if(!doubles.isEmpty())
        {
            String error = String.format("Параметр ContractNumber № договора %s уже существует для ЭП с ИД %d",
                    prodInsDTO.contractNumber(), doubles.get(0).getId());
            SException exp = new SException(error, new Throwable(""));
            exp.setHttpMethodType("Bad_Request");
            throw exp;
        }
        return Integer.valueOf(0);
    }
}
