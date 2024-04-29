package ru.stepup.homework.hw5.steps.prodinstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.entities.Agreement;
import ru.stepup.homework.hw5.repositories.AgreementRepository;
import ru.stepup.homework.hw5.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class Step2_2 implements ProdInsStepsPart2<ProductInstanceDTO> {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    AgreementRepository agreementRepo;
    @Override
    public List start(ProductInstanceDTO request, Integer productId) {
        // Шаг 2.2
        //Проверка таблицы ДС (agreement) на дубли
        for (var dc : request.instanceAgreements()) {
            final List<Agreement> listDC = agreementRepo.findAgreementsByNumber(dc.number());
            if (!listDC.isEmpty()) {
                String error = String.format("Параметр № Дополнительного соглашения (сделки) Number %s уже существует для ЭП с ИД %d",
                        dc.number(), listDC.get(0).getProduct_id());
                SException exp = new SException(error, new Throwable(""));
                exp.setHttpMethodType("Bad_Request");
                throw exp;
            }
        }
        return new ArrayList<>();
    }
}
