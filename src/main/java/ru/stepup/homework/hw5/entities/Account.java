package ru.stepup.homework.hw5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name="account_seq", sequenceName="account_id_seq", allocationSize=1)
    private Long id;
    @Column(name = "account_pool_id")
    Long accountPoolId;
    @Column(name = "account_number")
    String accountNumber;
    Boolean bussy;
}
