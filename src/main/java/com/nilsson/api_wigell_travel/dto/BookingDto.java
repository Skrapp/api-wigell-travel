package com.nilsson.api_wigell_travel.dto;

import java.time.LocalDate;

public record BookingDto (
        Long destinationId,
        String hotelName,
        LocalDate departureDate,
        LocalDate returnDate,
        Double totalPrice
){
}
