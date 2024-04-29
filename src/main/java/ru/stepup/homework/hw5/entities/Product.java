package ru.stepup.homework.hw5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity(name = "tpp_product")
@NoArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name="product_seq", sequenceName="tpp_product_id_seq", allocationSize=1)
    private Integer id;
    @Column(name = "product_code_id")
    private Long productCodeId;
    private Long clientId;
    private String type,number;
    private Long priority;
    @Column(name = "date_of_conclusion")
    private Date dateOfConclusion;
    @Column(name = "start_date_time")
    private Date startDateTime;
    @Column(name = "end_date_time")
    private Date endDateTime;
    private Long days;
    private int penalty_rate,nso;
    @Column(name = "threshold_amount")
    private int thresholdAmount;
    @Column(name = "requisite_type")
    private String requisiteType;
    @Column(name = "interest_rate_type")
    private String interestRateType;
    @Column(name = "tax_rate")
    private int taxRate;
    @Column(name = "reasone_close")
    private String reasoneClose;
    private String state;
}
