package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CustomerWithAccountCreateDto(
        @NotBlank @Size(max = 50) String firstName,
        @NotBlank @Size(max = 50) String lastName,
        @Valid AddressCreateDto address,
        @NotNull @PastOrPresent LocalDate dateOfBirth,
        @NotBlank @Size(max = 100) @Email String email,
        @Size(max = 20) @Pattern(regexp = "^\\+?[0-9\\s-()]+$") String phoneNumber,
        @Size(max = 50) String username
) {
}
