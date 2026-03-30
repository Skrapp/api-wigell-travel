package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DestinationPutUpdateDto(
        @Positive double weeklyRate,
        @Size(max = 50) String hotelName,
        @Size(max = 60) String city,
        @Size(max = 40) String country
) {
}
