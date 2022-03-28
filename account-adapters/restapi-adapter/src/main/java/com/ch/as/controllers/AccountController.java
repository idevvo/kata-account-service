package com.ch.as.controllers;

import com.ch.as.domain.account.Account;
import com.ch.as.exception.NegativeAmountException;
import com.ch.as.port.api.AccountDepositServicePort;
import com.ch.as.port.api.AccountWithdrawServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.BigInteger;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AccountController {

    private AccountDepositServicePort depositService;
    private AccountWithdrawServicePort withdrawService;

    @Operation(
            summary = "Deposit money",
            description = "Deposit money service",
            tags = {"Account"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "500", description = "negative amount")
            })
    @ExceptionHandler({NegativeAmountException.class})
    @PutMapping("/deposit")
    public Account deposit(@RequestParam BigInteger accountId, @RequestParam BigDecimal amount) {
        return depositService.deposit(accountId, amount);
    }

    @Operation(
            summary = "Withdrawal money",
            description = "Withdraw money service",
            tags = {"Account"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "500", description = "negative amount"),
                    @ApiResponse(responseCode = "500", description = "insufficient account funds")
            })
    @ExceptionHandler({NegativeAmountException.class})
    @PutMapping("/withdraw")
    public Account withdraw(@RequestParam BigInteger accountId, @RequestParam BigDecimal amount) {
        return withdrawService.withdraw(accountId, amount);
    }

    @Operation(
            summary = "Get account by ID",
            description = "Get account by ID",
            tags = {"Account"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation"),
                    @ApiResponse(responseCode = "400", description = "Invalid Parameter")
            })
    @GetMapping("/{accountId}")
    public Account getAccountById(@PathVariable BigInteger accountId) {
        System.out.println(depositService.findAccountById(accountId).toString());
        return depositService.findAccountById(accountId);
    }
}
