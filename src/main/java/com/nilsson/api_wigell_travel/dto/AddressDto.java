package com.nilsson.api_wigell_travel.dto;

public record AddressDto(
        Long addressId,
        String streetAddress,
        String city,
        String postalCode
) {
}
