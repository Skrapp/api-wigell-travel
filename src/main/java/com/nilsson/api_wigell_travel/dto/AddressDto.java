package com.nilsson.api_wigell_travel.dto;

public record AddressDto(
        String streetAddress,
        String city,
        String postalCode
) {
}
