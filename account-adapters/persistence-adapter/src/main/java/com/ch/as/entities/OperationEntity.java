package com.ch.as.entities;

import com.ch.as.domain.operation.OperationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @author iBrahim chniti
 */
@Entity
@Table(name = "OPERATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private OperationType operationType;
    private LocalDateTime date;
    private BigDecimal amount;
    private BigDecimal balance;

    @ManyToOne
    AccountEntity account;

}
