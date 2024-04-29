package ru.stepup.homework.hw5.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepup.homework.hw5.dto.*;
import ru.stepup.homework.hw5.entities.Agreement;
import ru.stepup.homework.hw5.repositories.ProductRegisterRepository;
import ru.stepup.homework.hw5.steps.prodinstance.ProdInsStepsPart1;
import ru.stepup.homework.hw5.steps.prodinstance.ProdInsStepsPart2;
import ru.stepup.homework.hw5.steps.prodregistr.ProdRegStep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class ProductInstanceService {
    private ProductInstanceDTO prodInstDto;
    @Autowired
    private final List<ProdInsStepsPart1> steps1;
    private final List<ProdInsStepsPart2> steps2;
    private Integer productId;
    private List<Agreement> agreements;
    private List<String> registerId = new ArrayList<>();
    private List<String> supplementaryAgreementId = new ArrayList<>();
    @Autowired
    ProductRegisterRepository productRegisterRepo;
    public Object execute(){
        //Шаги 1
        for (var step : steps1) {
            var result = step.start(prodInstDto);
            if(result != 0) {
                productId = result;
                break;
            }
        }
        //Шаги 2
        for (var step : steps2) {
            var result = step.start(prodInstDto,productId);
            if(result.size()>0)
            {
                agreements = result;
                break;
            }
        }

        //Формируем ответ
        return createAnswer(agreements,productId);
    }

    private Object createAnswer(List<Agreement> agreements, Integer productId) {

        //  Найдем записи в реестре платежей для формирования ответа
        List<String> registerId = new ArrayList<>();
        var tpp_productRegisters = productRegisterRepo.findAllByProductId(productId);
        if (!(tpp_productRegisters.isEmpty()))
            registerId = tpp_productRegisters.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        // Выберем все  agreement по agreementId
        List<String> supplementaryAgreementId = new ArrayList<>();
        if(agreements!=null)
            supplementaryAgreementId =  agreements.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        // Вернем готовый DTO ответа
        return new ProductInsResponseDTO(new ProdInsResponseDataDTO(
                productId.toString(),
                registerId,
                supplementaryAgreementId
        ));
    }
}
