package ru.stepup.homework.hw5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name = "tpp_ref_product_register_type")
public class ProductRegisterType {
    @Id
    @Column(name="internal_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productreg_type_seq")
    @SequenceGenerator(name="productreg_type_seq", sequenceName="tpp_ref_product_register_type_internal_id_seq", allocationSize=1)
    private Long id;
    String value;
    @Column(name="register_type_name")
    String registerTypeName;
    @Column(name="product_class_code")
    String productClassCode;
    @Column(name="register_type_start_date")
    Date registerTypeStartDate;
    @Column(name="register_type_end_date")
    Date registerTypeEndDate;
    @Column(name="account_type")
    String accountType;
}
