package com.nilsson.api_wigell_travel.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(Long id){super("Not able to find booking with id: " + id);}
}
