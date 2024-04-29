package ru.stepup.homework.hw5.mappers;

import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.entities.ProductRegister;

public class ProdRegRequestToProdRegEntity implements Mappable<ProductDto, ProductRegister> {
    @Override
    public ProductRegister map(ProductDto pdto) {
        var productReg = new ProductRegister();
//        productReg.setProductId(pdto.getProductRegRequest().getInstanceId());
//        productReg.setType(obj.getProductRegRequest().getRegisterTypeCode());
//        productReg.setAccountId(obj.getAccountId());
//        productReg.setCurrencyCode(obj.getProductRegRequest().getCurrencyCode());
//        productReg.setState("открыт");
        return null;
    }

}
