package com.ch.as.port.spi;

import com.ch.as.domain.account.Account;

import java.math.BigInteger;

/**
 * @author iBrahim chniti
 */
public interface AccountPersistencePort {

    Account findById(BigInteger accountId);

    Account update(Account account);
}
