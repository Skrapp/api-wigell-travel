package com.nilsson.api_wigell_travel.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long id){super("Not able to find customer with id: " + id);}
}
