package com.ch.as.adapters;

import com.ch.as.domain.account.Account;
import com.ch.as.mappers.AccountMapper;
import com.ch.as.port.spi.AccountPersistencePort;
import com.ch.as.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * @author iBrahim chniti
 */
@Service
public class AccountJpaAdapter implements AccountPersistencePort {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(BigInteger accountId) {
        var account = accountRepository.findById(accountId);
        return account.map(AccountMapper.INSTANCE::accountEntityToAccount).orElse(null);
    }

    @Override
    public Account update(Account account) {
        var accountEntity = AccountMapper.INSTANCE.accountToAccountEntity(account);
        var savedAccount = accountRepository.save(accountEntity);
        return AccountMapper.INSTANCE.accountEntityToAccount(savedAccount);
    }
}
