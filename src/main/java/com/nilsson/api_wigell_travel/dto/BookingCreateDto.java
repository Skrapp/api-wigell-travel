package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BookingCreateDto(
        @NotNull @Positive Long destinationId,
        @Size(max = 50) String hotelName,
        @NotNull @FutureOrPresent LocalDate departureDate,
        @NotNull @Positive int numberOfWeeks
) {
}
