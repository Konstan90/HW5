package ru.stepup.homework.hw5.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepup.homework.hw5.dto.ProdRegResponseDataDTO;
import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.dto.ProductRegResponseDTO;
import ru.stepup.homework.hw5.steps.prodregistr.ProdRegStep;

import java.util.List;

@Data
@Service
public class ProductService {
    private ProductDto productDto;
    @Autowired
    PRCreate prCreate;
    @Autowired
    private final List<ProdRegStep> steps;
    public Object execute()  {
        //Выполнение всех проверок с имплементацией интерфейса ProdRegStep
        for (ProdRegStep step : steps) {
            step.start(productDto);
        }

        // По сути последний шаг. Найти значение номера счета;c формировать новый ПР и записать его в БД

        var id = prCreate.add(productDto);

        //Формируем ответ
        return createAnswer(id);
        }

    private Object createAnswer(Integer  id) {
        return new ProductRegResponseDTO(new ProdRegResponseDataDTO(id.toString()));
    }
}
