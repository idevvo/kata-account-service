package com.ch.as.repository;

import com.ch.as.entities.AccountEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author iBrahim chniti
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop"
})
public class AccountRepositoryTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    @Sql("/accounts.sql")
    public void testUpdateAccountForDepositAndWithdrawCase() {
        var account = accountRepository.findById(BigInteger.valueOf(1));
        if (account.isPresent()) {
            AccountEntity accountEntity = account.get();

            // Deposit
            depositCase(accountEntity);

            // Withdraw
            withdrawCase(accountEntity);
        }
    }

    private void withdrawCase(AccountEntity accountEntity) {
        accountEntity.setBalance(accountEntity.getBalance().add(new BigDecimal(300)));
        accountRepository.save(accountEntity);
        var account = accountRepository.findById(BigInteger.valueOf(20));
        account.ifPresent(entity -> assertEquals(new BigDecimal("1000.00"), entity.getBalance()));
    }

    private void depositCase(AccountEntity accountEntity) {
        accountEntity.setBalance(accountEntity.getBalance().add(new BigDecimal(300)));
        accountRepository.save(accountEntity);
        var account = accountRepository.findById(BigInteger.valueOf(1));
        account.ifPresent(entity -> assertEquals(new BigDecimal("1300.00"), entity.getBalance()));
    }
}
