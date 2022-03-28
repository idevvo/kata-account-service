package com.ch.as.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @author iBrahim chniti
 */
@Entity
@Table(name = "ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger accountId;

    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OperationEntity> operations;
}
