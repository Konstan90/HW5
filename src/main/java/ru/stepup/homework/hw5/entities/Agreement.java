package ru.stepup.homework.hw5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name="agreement")
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agreement_seq")
    @SequenceGenerator(name="agreement_seq", sequenceName="agreement_id_seq", allocationSize=1)
    private Long id;
    private int product_id;
    @Column(name="generalAgreementId")
    private String generalAgreementId;
    @Column(name="supplementary_agreement_id")
    private String supplementaryAgreementId;
    @Column(name="arrangement_type")
    private String arrangementType;
    @Column(name="sheduler_job_id")
    private Long shedulerJobId;
    private String number;
    @Column(name="opening_date")
    private Date openingDate;
    @Column(name="closing_date")
    private Date closingDate;
    @Column(name="cancel_date")
    private Date cancelDate;
    @Column(name="validity_duration")
    private Long validityDuration;
    @Column(name="cancellation_reason")
    private String cancellationReason;
    private String status;
    @Column(name="interest_calculation_date")
    private Date interest_calculation_date;
    @Column(name="interest_rate")
    private int interestRate;
    private int coefficient;
    @Column(name="coefficient_action")
    private String coefficientAction;
    @Column(name="minimum_interest_rate")
    private int minimumInterestRate;
    @Column(name="minimum_interest_rate_coefficient")
    private int minimum_interestRateCoefficient;
    @Column(name="minimum_interest_rate_coefficient_action")
    private String minimumInterestRateCoefficientAction;
    @Column(name="maximal_interest_rate")
    private int maximalInterestRate;
    @Column(name="maximal_interest_rate_coefficient")
    private int maximalInterestRateCoefficient;
    @Column(name="maximal_interest_rate_coefficient_action")
    private String maximalInterestRateCoefficientAction;
}
