package com.nilsson.api_wigell_travel.dto;

public record DestinationDto(
        double weeklyRate,
        String hotelName,
        String city,
        String country
) {
}
