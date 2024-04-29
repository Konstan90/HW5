package ru.stepup.homework.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.stepup.homework.hw5.controllers.MainController;
import ru.stepup.homework.hw5.dto.*;
import ru.stepup.homework.hw5.entities.Product;
import ru.stepup.homework.hw5.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest(classes = {Main.class, Product.class})
public class IntegrationTests {
    @Autowired
    private MainController mainController;
    @Autowired ProductRepository productRepo;
    @BeforeAll
    public static void beforeAllTests(
            @Autowired ProductRepository productRepo
    ) {
        //productRepo.deleteAll();
    }

    @Test
    @DisplayName("Создание Экземпляра Продукта")
    public void createProduct() {
        final ResponseEntity<Object> response = mainController.createInstance(getRequest("11366"));
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Создание продуктового регистра")
    public void createProductRegister() {
        final ResponseEntity<Object> response = mainController.createAccount(getRequestProdReg(27));
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    private ProductDto getRequestProdReg(Integer instanceID) {
        final ProductDto request = new ProductDto(
                instanceID,
                "02.001.005_45343_CoDowFF",
                "Клиентский",
                "500",
                "0021",
                "00",
                "13",
                "Клиент РЖД",
                "Регион РЖД",
                "00",
                "222"
        );
        return request;
    }
    private ProductInstanceDTO getRequest(String contractNumber) {
        List<ProdInsAgreeDTO> agreeLst = new ArrayList<>();
        final ProductInstanceDTO request = new ProductInstanceDTO(
                null,
                "договор",
                "03.012.002",
                "03.012.002_47533_ComSoLd",
                "15",
                contractNumber,
                new Date(),
                1,
                0022,
                800,
                00,
                null,
                null,
                9,
                null,
                null,"0022","800","00",null,
                null, agreeLst);
        return request;
    }


}
