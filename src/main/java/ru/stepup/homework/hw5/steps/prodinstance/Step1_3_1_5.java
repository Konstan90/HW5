package ru.stepup.homework.hw5.steps.prodinstance;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.stepup.homework.hw5.controllers.SException;
import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.entities.Product;
import ru.stepup.homework.hw5.entities.ProductRegisterType;
import ru.stepup.homework.hw5.repositories.ProductClassRepository;
import ru.stepup.homework.hw5.repositories.ProductRegisterTypeRepository;
import ru.stepup.homework.hw5.repositories.ProductRepository;
import ru.stepup.homework.hw5.services.PRCreate;
import ru.stepup.homework.hw5.services.ProductCreate;

import java.util.List;

@Component
@Order(3)
public class Step1_3_1_5 implements ProdInsStepsPart1<ProductInstanceDTO> {
    private static final String CLIENT_ACCOUNT_TYPE = "Клиентский";
    @Autowired
    private ProductRegisterTypeRepository prodRegTypeRepo;
    @Autowired
    private ProductClassRepository prodClassRepo;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    ProductCreate prCreate;
    @Autowired
    PRCreate prRegCreate;

    private Product product = new Product();
    @Override
    @Transactional
    public Integer start(ProductInstanceDTO prodInsDTO) {
        if (prodInsDTO.instanceId() != null) return Integer.valueOf(0); //Пропускаем этот шаг, если создавать экземпляр не нужно
        //Шаг 1.3
        //По КодуПродукта найти связные записи в Каталоге Типа регистра
        var prodCls = prodClassRepo.findFirstByValue(prodInsDTO.productCode());

        var regTypes = getListReg(prodInsDTO);

        // Шаг 1.4
        //Добавить строку в таблицу tpp_product
        var product = prCreate.add(prodInsDTO,prodCls);
        //System.out.println("ID продукта " + product.getId());

        // Шаг 1.5
        //Добавить в таблицу ПР (tpp_product_registry) строки
        ProductDto productDto = new ProductDto(
                product.getId(),
                prodInsDTO.registerType(),
                null,
                prodInsDTO.isoCurrencyCode(),
                prodInsDTO.branchCode(),
                prodInsDTO.priority().toString(),
                prodInsDTO.mdmCode(),
                null,
                null,
                null,
                null
                );
        //System.out.println(productDto);
        var prReg = prRegCreate.add(productDto);
        //System.out.println("Регистр добавлен");
        return product.getId();

    }

    private List<ProductRegisterType> getListReg(ProductInstanceDTO prodInsDTO) {
        var prodCls = prodClassRepo.findFirstByValue(prodInsDTO.productCode());

        var prodRegTypeList =
                prodRegTypeRepo.findProductRegisterTypesByProductClassCodeAndAccountType(
                        prodInsDTO.productCode(), CLIENT_ACCOUNT_TYPE);
        if (prodRegTypeList.isEmpty()) {
            String error = String.format("КодПродукта %s не найдено в Каталоге продуктов tpp_ref_product_class",
                    prodInsDTO.productCode());
            SException exp = new SException(error, new Throwable(""));
            exp.setHttpMethodType("Not_Found");
            throw exp;
        }
        return prodRegTypeList;
    }
}
