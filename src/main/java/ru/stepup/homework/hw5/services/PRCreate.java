package ru.stepup.homework.hw5.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.entities.ProductRegister;
import ru.stepup.homework.hw5.repositories.AccountPoolRepository;
import ru.stepup.homework.hw5.repositories.AccountRepository;
import ru.stepup.homework.hw5.repositories.ProductRegisterRepository;
import ru.stepup.homework.hw5.repositories.ProductRegisterTypeRepository;

@Data
@Service
public class PRCreate {
    @Autowired
    private AccountPoolRepository accPoolRep;
    @Autowired
    private AccountRepository accRep;
    @Autowired
    private ProductRegisterRepository prodRegRepo;
    @Autowired
    private ProductRegisterTypeRepository prodRegType;

    public Integer add(ProductDto productDto) {
        //System.out.println(productDto);
        var accountPool = accPoolRep.findAccountPoolByBranchCodeAndCurrencyCodeAndMdmCodeAndPriorityCodeAndRegisterTypeCode(productDto.branchCode(), productDto.currencyCode(), productDto.mdmCode(), productDto.priorityCode(), productDto.registryTypeCode());
        var account = accRep.findFirstByAccountPoolIdOrderById(accountPool.getId());
        var productReg = new ProductRegister();
        productReg.setProductId(productDto.instanceId());
        productReg.setType(prodRegType.findFirstByValue(productDto.registryTypeCode()).getValue());
        productReg.setAccountNumber(account.getAccountNumber());
        productReg.setCurrencyCode(productDto.currencyCode());
        productReg.setState("OPEN");
        productReg.setAccount(account.getId());
        return prodRegRepo.save(productReg).getProductId();
    }

}
