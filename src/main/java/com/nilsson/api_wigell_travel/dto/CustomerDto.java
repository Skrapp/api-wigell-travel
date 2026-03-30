package com.nilsson.api_wigell_travel.dto;

public record CustomerDto (
        String firstName,
        String lastName,
        AddressDto address,
        String email,
        String phoneNumber
) {
}
