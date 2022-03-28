package com.ch.as.domain.account;

import com.ch.as.domain.operation.OperationType;
import com.ch.as.exception.InsufficientAccountFundsException;
import com.ch.as.exception.NegativeAmountException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.math.BigDecimal.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author iBrahim chniti
 */
public class CurrentAccountTest {

    private static Account account;

    @Before
    public void init() {
        account = CurrentAccount.builder()
                .accountId(BigInteger.valueOf(1))
                .balance(new BigDecimal(100))
                .operations(new ArrayList<>())
                .build();
    }

    @Test
    public void deposit_ValidCase() {
        account.deposit(new BigDecimal(100));
        BigDecimal balance = account.getBalance();
        assertEquals(valueOf(200), balance);
        assertEquals(1, account.getOperations().size());
        assertTrue(account.getOperations().stream().anyMatch(operation -> OperationType.DEPOSIT.equals(operation.getOperationType())));
    }

    @Test(expected = NegativeAmountException.class)
    public void deposit_NegativeAmountExceptionCase() throws NegativeAmountException {
        account.deposit(valueOf(-100));
    }

    @Test
    public void withdraw_ValidCase() {
        account.withdraw(new BigDecimal(100));
        BigDecimal balance = account.getBalance();
        assertEquals(valueOf(0), balance);
        assertEquals(1, account.getOperations().size());
        assertTrue(account.getOperations().stream().anyMatch(operation -> OperationType.WITHDRAW.equals(operation.getOperationType())));
    }

    @Test(expected = NegativeAmountException.class)
    public void withdraw_NegativeAmountExceptionCase() throws NegativeAmountException {
        account.deposit(valueOf(-100));
    }

    @Test(expected = InsufficientAccountFundsException.class)
    public void withdraw_InsufficientFundsExceptionCase() throws InsufficientAccountFundsException {
        account.withdraw(valueOf(300));
    }

    @Test
    public void depositAndWithdraw_ValidCase() {
        account.deposit(new BigDecimal(400));
        account.withdraw(new BigDecimal(100));
        BigDecimal balance = account.getBalance();
        assertEquals(valueOf(400), balance);
        assertEquals(2, account.getOperations().size());
        assertTrue(account.getOperations().stream().anyMatch(operation -> OperationType.DEPOSIT.equals(operation.getOperationType())));
        assertTrue(account.getOperations().stream().anyMatch(operation -> OperationType.WITHDRAW.equals(operation.getOperationType())));
    }
}
