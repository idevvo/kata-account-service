package com.ch.as.domain.operation;

import com.ch.as.exception.OperationTypeDoesNotExistException;

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
