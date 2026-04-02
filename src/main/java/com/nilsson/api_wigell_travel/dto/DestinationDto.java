package com.nilsson.api_wigell_travel.dto;

public record DestinationDto(
        Long id,
        double weeklyRate,
        String hotelName,
        String city,
        String country
) {
}
