package com.ch.as.configuration;

import com.ch.as.adapters.AccountJpaAdapter;
import com.ch.as.port.api.AccountDepositServicePort;
import com.ch.as.port.api.AccountWithdrawServicePort;
import com.ch.as.port.spi.AccountPersistencePort;
import com.ch.as.service.AccountDepositServiceImpl;
import com.ch.as.service.AccountWithdrawServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author iBrahim chniti
 */
@Configuration
public class AccountServiceConfiguration {

    @Bean
    public AccountPersistencePort accountPersistence() {
        return new AccountJpaAdapter();
    }

    @Bean
    public AccountDepositServicePort accountDepositService() {
        return new AccountDepositServiceImpl(accountPersistence());
    }

    @Bean
    public AccountWithdrawServicePort accountWithdrawService() {
        return new AccountWithdrawServiceImpl(accountPersistence());
    }

}
