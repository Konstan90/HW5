package ru.stepup.homework.hw5.mappers;

import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.entities.Product;

public class ProdInsDtoToProductEntity implements Mappable<ProductInstanceDTO, Product> {
    @Override
    public Product map(ProductInstanceDTO obj) {
//        Product pr = new Product();
//        pr.setProductCodeId(Long.valueOf(obj.productCode()));
//        pr.setClientId(obj.c);
        return null;
    }
}
