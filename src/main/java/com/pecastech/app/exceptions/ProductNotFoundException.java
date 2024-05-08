package com.pecastech.app.exceptions;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Product not found try another id");
    }
    
    public ProductNotFoundException(String message) {
        super(message);
    }
}