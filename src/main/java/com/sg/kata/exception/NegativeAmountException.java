package com.sg.kata.exception;

/**
 * @author iBrahim chniti
 */
public class NegativeAmountException extends RuntimeException {

    public NegativeAmountException() {
        super("Unauthorized operation: Operation amount must be greater than zero");
    }

}
