package com.ch.as.mappers;

import com.ch.as.entities.AccountEntity;
import com.ch.as.domain.account.Account;
import com.ch.as.domain.account.CurrentAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author iBrahim chniti
 */
@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    CurrentAccount accountEntityToAccount(AccountEntity account);

    AccountEntity accountToAccountEntity(Account account);

}
