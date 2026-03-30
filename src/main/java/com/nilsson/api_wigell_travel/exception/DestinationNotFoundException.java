package com.nilsson.api_wigell_travel.exception;

public class DestinationNotFoundException extends RuntimeException {
    public DestinationNotFoundException(String message) {
        super(message);
    }
    public DestinationNotFoundException(Long id){super("Not able to find destination with id: " + id);}
}
