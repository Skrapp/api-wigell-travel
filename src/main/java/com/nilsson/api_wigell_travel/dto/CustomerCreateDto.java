package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerCreateDto(
        @NotBlank @Size(max = 50) String firstName,
        @NotBlank @Size(max = 50) String lastName,
        @Valid AddressCreateDto address,
        @NotBlank @Size(max = 100) @Email String email,
        @Size(max = 20) @Pattern(regexp = "^\\+?[0-9\\s-()]+$") String phoneNumber
) {
}
