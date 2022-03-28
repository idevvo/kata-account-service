package com.ch.as.service;

import com.ch.as.domain.account.Account;
import com.ch.as.domain.account.AccountService;
import com.ch.as.port.api.AccountDepositServicePort;
import com.ch.as.port.spi.AccountPersistencePort;
import com.ch.as.exception.InsufficientAccountFundsException;
import com.ch.as.exception.NegativeAmountException;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author iBrahim chniti
 */
@RequiredArgsConstructor
public class AccountDepositServiceImpl implements AccountDepositServicePort {

    private final AccountPersistencePort persistence;

    @Override
    public Account deposit(BigInteger accountId, BigDecimal amount) {
        final Account account = persistence.findById(accountId);
        AccountService accountService = new AccountService(account);
        accountService.deposit(amount);
        return persistence.update(account);
    }

    @Override
    public Account findAccountById(BigInteger accountId) throws NegativeAmountException, InsufficientAccountFundsException {
        return persistence.findById(accountId);
    }
}
