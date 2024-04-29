package ru.stepup.homework.hw5.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProdInsAgreeDTO(
        String generalAgreementId,
        String supplementaryAgreementId,
        String arrangementType,
        @NotNull(message = "Не должен быть пустым")
        String number,
        Integer shedulerJobId,
        @NotNull(message = "Не должен быть пустым")
        Date openingDate,
        Date closingDate,
        Date cancelDate,
        Integer validityDuration,
        String cancellationReason,
        String status,
        Date interestCalculationDate,
        float interestRate,
        float coefficient,
        String coefficientAction,
        float minimumInterestRate,
        String minimumInterestRateCoefficient,
        String minimumInterestRateCoefficientAction,
        Double maximalInterestRate,
        Double maximalInterestRateCoefficient,
        String maximalInterestRateCoefficientAction
) {
}
