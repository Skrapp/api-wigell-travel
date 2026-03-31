package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CustomerPatchUpdateDto(
        @Size(max = 50) String firstName,
        @Size(max = 50) String lastName,
        @Size(max = 100) @Email String email,
        @PastOrPresent LocalDate dateOfBirth,
        @Size(max = 20) @Pattern(regexp = "^\\+?[0-9\\s-()]+$") String phoneNumber
) {
}
