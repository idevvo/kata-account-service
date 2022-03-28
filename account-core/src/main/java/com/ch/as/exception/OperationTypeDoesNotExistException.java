package com.ch.as.exception;

/**
 * @author iBrahim chniti
 */
public class OperationTypeDoesNotExistException extends RuntimeException {

    public OperationTypeDoesNotExistException(String type) {
        super(String.format("Operation of type '%s' does not exits.", type));
    }
}
