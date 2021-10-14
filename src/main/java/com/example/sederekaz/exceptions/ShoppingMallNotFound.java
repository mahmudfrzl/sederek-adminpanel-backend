package com.example.sederekaz.exceptions;

public class ShoppingMallNotFound extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ShoppingMallNotFound(String message) {
        super(message);
    }
}
