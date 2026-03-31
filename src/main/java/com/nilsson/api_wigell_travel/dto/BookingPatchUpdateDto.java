package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.constraints.Size;

public record BookingPatchUpdateDto(
        Long destinationId,
        @Size(max = 50) String hotelName,
        Integer numberOfWeeks
) {
}
