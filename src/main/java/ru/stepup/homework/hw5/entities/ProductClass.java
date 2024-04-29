package ru.stepup.homework.hw5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="tpp_ref_product_class")
public class ProductClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productclass_seq")
    @SequenceGenerator(name="productclass_seq", sequenceName="tpp_ref_product_class_internal_id_seq", allocationSize=1)
    private Long internalId;
    String value;
    @Column(name = "gbi_code")
    String gbiCode;
    @Column(name = "gbi_name")
    String gbiName;
    @Column(name = "product_row_code")
    String productRowCode;
    @Column(name = "product_row_name")
    String productRowName;
    @Column(name = "subclass_code")
    String subclassCode;
    @Column(name = "subclass_name")
    String subclassName;
}
