package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record DestinationCreateDto(
        @NotNull @Positive double weeklyRate,
        @Size(max = 50) String hotelName,
         @Size(max = 60) String city,
        @NotBlank @Size(max = 40) String country
) {
}
