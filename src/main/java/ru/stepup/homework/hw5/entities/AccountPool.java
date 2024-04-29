package ru.stepup.homework.hw5.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="account_pool")
public class AccountPool {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_pool_seq")
    @SequenceGenerator(name="account_pool_seq", sequenceName="account_pool_id_seq", allocationSize=1)
    private Long id;
    @Column(name = "branch_code")
    String branchCode;
    @Column(name = "currency_code")
    String currencyCode;
    @Column(name = "mdm_code")
    String mdmCode;
    @Column(name = "priority_code")
    String priorityCode;
    @Column(name = "registry_type_code")
    String registerTypeCode;
}
