package com.ch.as.repository;

import com.ch.as.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author iBrahim chniti
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, BigInteger> {
}
