package ru.stepup.homework.hw5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProductDto(
        @NotNull(message = "Не должен быть пустым")
        Integer instanceId,
        String registryTypeCode,
        String accountType,
        String currencyCode,
        String branchCode,
        String priorityCode,
        String mdmCode,
        String clientCode,
        String trainRegion,
        String counter,
        String salesCode
){
}
