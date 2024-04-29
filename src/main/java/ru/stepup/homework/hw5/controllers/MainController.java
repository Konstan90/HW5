package ru.stepup.homework.hw5.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import ru.stepup.homework.hw5.dto.ProductDto;
import ru.stepup.homework.hw5.dto.ProductInstanceDTO;
import ru.stepup.homework.hw5.services.ProductInstanceService;
import ru.stepup.homework.hw5.services.ProductService;
@Component
@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private final ProductService productService;

    @Autowired
    private final ProductInstanceService productInstanceService;
    @Autowired
    public MainController(ProductService productService, ProductInstanceService productInstanceService) {
        this.productService = productService;
        this.productInstanceService = productInstanceService;
    }

    //Метод создания продуктового регистра (ПР)
    @PostMapping(value = "corporate-settlement-account/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createAccount(@Valid @RequestBody ProductDto pdto) {
        productService.setProductDto(pdto);
        Object obj = productService.execute();
        return new ResponseEntity<>(obj, new HttpHeaders(), HttpStatus.CREATED);
    }

    //Метод создания экземпляра продукта (ЭП)
    @PostMapping(value = "corporate-settlement-instance/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createInstance(@Valid @RequestBody ProductInstanceDTO pidto) {
        productInstanceService.setProdInstDto(pidto);
        Object obj = productInstanceService.execute();
        return new ResponseEntity<>(obj, new HttpHeaders(), HttpStatus.CREATED);
    }
}

