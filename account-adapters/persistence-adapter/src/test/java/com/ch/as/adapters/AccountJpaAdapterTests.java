package com.ch.as.adapters;

import com.ch.as.entities.AccountEntity;
import com.ch.as.domain.account.Account;
import com.ch.as.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author iBrahim chniti
 */
@ExtendWith(MockitoExtension.class)
public class AccountJpaAdapterTests {

    private AccountEntity accountEntity;

    @InjectMocks
    private AccountJpaAdapter accountJpaAdapter;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    public void setUp() {
        accountEntity = AccountEntity.builder()
                .accountId(BigInteger.valueOf(1))
                .balance(new BigDecimal(100))
                .operations(new ArrayList<>())
                .build();
    }

    @Test
    public void testUpdate() {
        when(accountRepository.save(any())).thenReturn(accountEntity);
        Account account = accountJpaAdapter.update(any());
        assertEquals(BigInteger.valueOf(1), account.getAccountId());
        verify(accountRepository).save(any());
    }

    @Test
    public void testFindById() {
        when(accountRepository.findById(any())).thenReturn(ofNullable(accountEntity));
        Account account = accountJpaAdapter.findById(any());
        assertEquals(BigInteger.valueOf(1), account.getAccountId());
        verify(accountRepository).findById(any());
    }
}
