package ru.stepup.homework.hw5.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;
public record ProductInstanceDTO(
        Integer instanceId,
        @NotNull(message = "Не должен быть пустым")
        String productType,
        @NotNull(message = "Не должен быть пустым")
        String productCode,
        @NotNull(message = "Не должен быть пустым")
        String registerType,
        @NotNull(message = "Не должен быть пустым")
        String mdmCode,
        @NotNull(message = "Не должен быть пустым")
        String contractNumber,
        @NotNull(message = "Не должен быть пустым")
        Date contractDate,
        @NotNull(message = "Не должен быть пустым")
        Integer priority,
        Integer interestRatePenalty,
        float minimalBalance,
        Integer thresholdAmount,
        String accountingDetails,
        String rateType,
        Integer taxPercentageRate,
        Double technicalOverdraftLimitAmount,
        @NotNull(message = "Не должен быть пустым")
        Integer contractId,
        @NotNull(message = "Не должен быть пустым")
        String branchCode,
        @NotNull(message = "Не должен быть пустым")
        String isoCurrencyCode,
        @NotNull(message = "Не должен быть пустым")
        String urgencyCode,
        Integer referenceCode,
        Map<String, List<ProdInsAddPropsVIPDTO>> additionalPropertiesVIP,
        List<ProdInsAgreeDTO> instanceAgreements
) {
}
