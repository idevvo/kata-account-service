package com.sg.kata.exception;

/**
 * @author iBrahim chniti
 */
public class InsufficientAccountFundsException extends RuntimeException {

    public InsufficientAccountFundsException() {
        super("Unauthorized operation: Insufficient account funds");
    }

}
