package ru.stepup.homework.hw5.steps.prodinstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProdInsAgreeDTO;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.repositories.AgreementRepository;

import java.util.List;

@Component
@Order(2)
public class Step1_2 implements ProdInsStepsPart1<ProductInstanceDTO> {
    @Autowired
    AgreementRepository agreementRepo;
    @Override
    public Integer start(ProductInstanceDTO prodInsDTO) {
        //Шаг 1.2
        //Проверка таблицы ДС (agreement) на дубли
        if(prodInsDTO.instanceId() != null ) return Integer.valueOf(0); //Пропускаем этот шаг, если создавать экземпляр не нужно

        List<ProdInsAgreeDTO> agreeementLst = prodInsDTO.instanceAgreements();
        for (var agr: agreeementLst) {
            var agreement = agreementRepo.findFirstByNumber(agr.number());
            if (!(agreement == null))
            {
                String error = String.format("Параметр Дополнительного соглашения(сделки) Number %s уже существует для ЭП с ИД %d",
                        agr.number(), agreement.getId());
                SException exp = new SException(error, new Throwable(""));
                exp.setHttpMethodType("Bad_Request");
                throw exp;
            }
        }
        return Integer.valueOf(0);
    }
}
