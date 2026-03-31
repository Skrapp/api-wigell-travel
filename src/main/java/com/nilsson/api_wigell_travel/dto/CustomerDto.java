package com.nilsson.api_wigell_travel.dto;

import java.time.LocalDate;

public record CustomerDto (
        String firstName,
        String lastName,
        AddressDto address,
        LocalDate dateOfBirth,
        String email,
        String phoneNumber
) {
}
