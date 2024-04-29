package ru.stepup.homework.hw5.steps.prodinstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.entities.Agreement;
import ru.stepup.homework.hw5.repositories.AgreementRepository;
import ru.stepup.homework.hw5.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@Order(4)
public class Step2_3 implements ProdInsStepsPart2<ProductInstanceDTO> {
    @Autowired
    ProductRepository productRepo;
    @Autowired
    AgreementRepository agreementRepo;
    @Override
    public List start(ProductInstanceDTO request, Integer productId) {
        // Шаг 2.3
        // Формирование agreements
        List<Agreement> agreements = new ArrayList<>(request.instanceAgreements().size());
        for (var dc : request.instanceAgreements()) {
            Agreement agreement = new Agreement();
            agreement.setProduct_id(productId);
            agreement.setNumber(dc.number());
            agreement = agreementRepo.save(agreement);
            agreements.add(agreement);
        }
        return agreements;
    }
}
