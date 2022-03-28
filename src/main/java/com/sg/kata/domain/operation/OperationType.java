package com.sg.kata.domain.operation;

import com.sg.kata.exception.OperationTypeDoesNotExistException;

/**
 * @author iBrahim chniti
 */
public enum OperationType {
    DEPOSIT, WITHDRAW;

    public static OperationType fromString(String type) {
        switch (type.toUpperCase()) {
            case "DEPOSIT":
                return DEPOSIT;
            case "WITHDRAW":
                return WITHDRAW;
            default:
                throw new OperationTypeDoesNotExistException(type);
        }
    }
}
