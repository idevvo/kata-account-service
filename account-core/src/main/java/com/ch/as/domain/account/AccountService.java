package com.ch.as.domain.account;

import java.math.BigDecimal;

/**
 * @author iBrahim chniti
 */
public class AccountService {

    private final Account account;

    public AccountService(Account account) {
        this.account = account;
    }

    public void deposit(BigDecimal amount) {
        account.deposit(amount);
    }

    public void withdraw(BigDecimal amount) {
        account.withdraw(amount);
    }
}
