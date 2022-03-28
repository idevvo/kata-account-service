package com.sg.kata.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author iBrahim chniti
 */
@Data
@ToString
@AllArgsConstructor
@Builder
public class Operation {

    private final OperationType operationType;
    private final LocalDateTime date;
    private final BigDecimal amount;
    private final BigDecimal balance;
}
