package com.nilsson.api_wigell_travel.dto;

import java.time.LocalDate;
import java.util.List;

public record CustomerDto (
        Long id,
        String firstName,
        String lastName,
        List<AddressDto> address,
        LocalDate dateOfBirth,
        String email,
        String phoneNumber
) {
}
