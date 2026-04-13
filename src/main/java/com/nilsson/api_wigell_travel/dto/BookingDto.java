package com.nilsson.api_wigell_travel.dto;

import java.time.LocalDate;

public record BookingDto (
        Long bookingId,
        Long destinationId,
        String hotelName,
        LocalDate departureDate,
        LocalDate returnDate,
        Double totalPriceSek,
        Double totalPricePln
){
}
