package ru.stepup.homework.hw5.entities;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name="tpp_product_register")
public class ProductRegister {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productreg_seq")
    @SequenceGenerator(name="productreg_seq", sequenceName="tpp_product_register_id_seq", allocationSize=1)
    private Long id;
    @Column(name="product_id")
    private Integer productId;
    private String type;
    private Long account;
    @Column(name="currency_code")
    private String currencyCode;
    private String state;
    @Column(name="account_number")
    private String accountNumber;
}
