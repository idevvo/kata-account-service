package com.sg.kata.domain.account;

import com.sg.kata.domain.operation.Operation;
import com.sg.kata.exception.InsufficientAccountFundsException;
import com.sg.kata.exception.NegativeAmountException;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author iBrahim chniti
 */
@Data
@ToString
@SuperBuilder
public abstract class Account {

    private final Long accountId;
    private BigDecimal balance;
    private List<Operation> operations;

    protected abstract void deposit(BigDecimal amount);

    protected abstract void withdraw(BigDecimal amount);

    /**
     * Validates that the current amount of money is not negative.
     *
     * @param amount the amount of money to validate
     * @throws NegativeAmountException if the amount to withdraw is negative
     */
    protected void validateNegativeAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new NegativeAmountException();
        }
    }

    /**
     * Validates that the account balance is sufficient for the expected operation.
     *
     * @param amount the amount of money to validate
     * @throws InsufficientAccountFundsException if the account doesn't have enough funds for the operation
     */
    protected void validateFundsSufficiency(BigDecimal amount) {
        if (getBalance().compareTo(amount) < 0) {
            throw new InsufficientAccountFundsException();
        }
    }
}
