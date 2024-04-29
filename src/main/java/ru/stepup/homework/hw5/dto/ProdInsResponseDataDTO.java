package ru.stepup.homework.hw5.dto;

import java.util.HashMap;
import java.util.List;

public record ProdInsResponseDataDTO(
        String instanceId,
        List<String> registerId,
        List<String> supplementaryAgreementId
) {
}
