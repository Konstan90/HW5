package ru.stepup.homework.hw5.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.entities.Product;
import ru.stepup.homework.hw5.entities.ProductClass;
import ru.stepup.homework.hw5.repositories.ProductRepository;

import java.util.List;

@Service
@Data
public class ProductCreate {
    @Autowired
    ProductRepository productRepo;
    public Product add(ProductInstanceDTO pidto, ProductClass prCls) {
        var product = new Product();
        if (!(prCls == null))
            product.setProductCodeId(prCls.getInternalId());

        product.setClientId(Long.valueOf(pidto.mdmCode()));
        product.setNumber(pidto.contractNumber());
        product.setPriority(Long.valueOf(pidto.priority()));
        product.setType(pidto.productType());
        product.setDateOfConclusion(pidto.contractDate());

        product.setPenalty_rate(pidto.interestRatePenalty());
        product.setThresholdAmount(pidto.thresholdAmount());
        product.setTaxRate(pidto.taxPercentageRate());
        Product productSave =  productRepo.save(product);
        return productSave;
    }
}
