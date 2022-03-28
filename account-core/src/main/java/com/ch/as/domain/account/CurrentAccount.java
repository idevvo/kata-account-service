package com.ch.as.domain.account;

import com.ch.as.domain.operation.Operation;
import com.ch.as.domain.operation.OperationType;
import com.ch.as.exception.InsufficientAccountFundsException;
import com.ch.as.exception.NegativeAmountException;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author iBrahim chniti
 */
@SuperBuilder
public class CurrentAccount extends Account {

    /**
     * Deposits funds to account if the supplied amount is positive.
     * Saves the deposit transaction into the account operations.
     *
     * @param amount the given amount of money to deposit
     * @throws NegativeAmountException if the amount to withdraw is negative
     */
    @Override
    public void deposit(BigDecimal amount) {
        validateNegativeAmount(amount);

        setBalance(getBalance().add(amount));
        addOperation(amount, OperationType.DEPOSIT);
    }

    /**
     * Withdraws funds from account if it has enough funds, and the supplied amount is positive.
     * Saves the withdrawal transaction in the account operations.
     *
     * @param amount the given amount of money to withdraw
     * @throws NegativeAmountException           if the amount to withdraw is negative
     * @throws InsufficientAccountFundsException if the account doesn't have enough funds for the operation
     */
    @Override
    public void withdraw(BigDecimal amount) {
        validateNegativeAmount(amount);
        validateFundsSufficiency(amount);

        setBalance(getBalance().subtract(amount));
        addOperation(amount, OperationType.WITHDRAW);
    }

    /**
     * Add the requested transaction to the account operations history.
     *
     * @param amount        the given amount of money to validate
     * @param operationType the given type of operation to add
     */
    private void addOperation(BigDecimal amount, OperationType operationType) {
        Operation operation = Operation.builder()
                .operationType(operationType)
                .amount(amount)
                .balance(getBalance())
                .date(LocalDateTime.now())
                .build();
        if (Objects.nonNull(getOperations())) {
            this.getOperations().add(operation);
        } else {
            List<Operation> op = new ArrayList<>();
            op.add(operation);
            this.setOperations(op);
        }
    }
}
