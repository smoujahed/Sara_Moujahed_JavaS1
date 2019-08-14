package com.company.SaraMoujahedU1Capstone.exception;

/**
 * Exception class to handle not found cases in get APIs
 */
public class OrderQuantityException extends RuntimeException {

    public OrderQuantityException() {
    }

    public OrderQuantityException(String message) {
        super(message);
    }
}
