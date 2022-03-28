package com.ch.as.port.api;

import com.ch.as.domain.account.Account;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author iBrahim chniti
 */
public interface AccountWithdrawServicePort {

    Account withdraw(BigInteger accountId, BigDecimal amount);
}
