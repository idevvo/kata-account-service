package com.sg.kata.domain.account;

import com.sg.kata.domain.operation.Operation;
import com.sg.kata.domain.operation.OperationType;
import com.sg.kata.exception.InsufficientAccountFundsException;
import com.sg.kata.exception.NegativeAmountException;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

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
     * Add the requested operation with the amount to the account operations history.
     *
     * @param amount        the given amount of money to validate
     * @param operationType the given type of operation to add
     */
    private void addOperation(BigDecimal amount, OperationType operationType) {
        Operation operation = Operation.builder()
                .operationType(operationType)
                .amount(amount)
                .balance(getBalance())
                .build();
        getOperations().add(operation);
    }
}
