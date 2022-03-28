package com.ch.as.controllers;

import com.ch.as.port.api.AccountDepositServicePort;
import com.ch.as.port.api.AccountWithdrawServicePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.mockito.BDDMockito.eq;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author iBrahim chniti
 */
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountDepositServicePort depositService;

    @MockBean
    private AccountWithdrawServicePort withdrawService;


    @Test
    public void deposit() throws Exception {
        mockMvc.perform(
                        put("/account/deposit?accountId=1&amount=900")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        then(depositService)
                .should()
                .deposit(eq(BigInteger.valueOf(1)), eq(BigDecimal.valueOf(900)));
    }

   // @Test
    public void deposit_ErrorMessage() throws Exception {
        // When
        /* MockHttpServletResponse response = */
        mockMvc.perform(
                        put("/account/deposit?accountId=1&amount=-1000")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andReturn();

        // then
        /*System.out.println(response.getContentAsString());
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());*/
        then(depositService)
                .should()
                .deposit(eq(BigInteger.valueOf(1)), eq(BigDecimal.valueOf(-900)));
    }

    @Test
    public void withdraw() throws Exception {
        mockMvc.perform(
                        put("/account/withdraw?accountId=1&amount=900")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        then(withdrawService)
                .should()
                .withdraw(eq(BigInteger.valueOf(1)), eq(BigDecimal.valueOf(900)));
    }

   // @Test
    public void withdraw_ErrorMessage() throws Exception {
        mockMvc.perform(
                        put("/account/withdraw?accountId=1&amount=-900")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is5xxServerError())
                .andReturn();

        then(withdrawService)
                .should()
                .withdraw(eq(BigInteger.valueOf(1)), eq(BigDecimal.valueOf(-900)));
    }
}
